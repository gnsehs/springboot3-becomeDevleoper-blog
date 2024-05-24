package me.shinsunyoung.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.Article;
import me.shinsunyoung.springbootdeveloper.dto.ArticleListViewResponse;
import me.shinsunyoung.springbootdeveloper.dto.ArticleViewResponse;
import me.shinsunyoung.springbootdeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles);

        return "articleList"; // articleList.html 이라는 뷰 조회
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);

        model.addAttribute("article",new ArticleViewResponse(article));

        return "article";
    }
/*
쿼리 파라미터: HTTP 요청에서 URL의 끝에 ?로 시작하는 키값, &로 구분함
e.g. /new-article?id=132
 */
        @GetMapping("/new-article")
        public String newArticle(@RequestParam(required = false) Long id, Model model) {
            if (id == null) {
                ArticleViewResponse res = new ArticleViewResponse();
                model.addAttribute("article",res );
                System.out.println("TEST no::artcile id = " + res.getId());
        } else {
            Article article = blogService.findById(id);
            ArticleViewResponse res2 = new ArticleViewResponse(article);
            model.addAttribute("article", res2);
            System.out.println("TEST yes::artcile id = " + res2.getId());
        }

        return "newArticle";
    }
}
