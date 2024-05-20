package me.shinsunyoung.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.Article;
import me.shinsunyoung.springbootdeveloper.dto.AddArticleRequest;
import me.shinsunyoung.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/* 컨트롤러 메서드에는 URL 매핑 GET.. */
@RequiredArgsConstructor
@RestController // HTTP 응답으로 Response Body에 의해 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles") // HTTP 메서드가 Post일때 전달받은 URL과 동일하면 메서드로 매핑
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) { // RequestBody로 요청 본문값 매핑
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle); // 201 created
    }

    /*
    RequestBody는 HTTP를 요청할때 응답에 해당하는 값을 RequestBody 애너테이션이 붙은 대상 객체인 AddArticleRequest에
    매핑
    @RequestBody
    HTTP Request Message Body를 통해 전달된 데이터를 지정한 객체로 역직렬화하는 애노테이션
     */
}
