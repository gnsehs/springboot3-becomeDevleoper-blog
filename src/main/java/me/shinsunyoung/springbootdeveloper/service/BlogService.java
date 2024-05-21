package me.shinsunyoung.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.Article;
import me.shinsunyoung.springbootdeveloper.dto.AddArticleRequest;
import me.shinsunyoung.springbootdeveloper.dto.UpdateArticleRequest;
import me.shinsunyoung.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가 // 빈을 생성자로 생성
@Service // 해당 클래스를 빈으로 서블릿 컨테이너에 등록ㅁ
public class BlogService {
    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request) { // article db에 저장 
        return blogRepository.save(request.toEntity()); // save()는 JPArepo.. 에서 지원
    }

    // RequiredArgsConstructor 없다면
//    @Autowired
//    public BlogService(BlogRepository blogRepository) {
//        this.blogRepository = blogRepository;
//    }


    public List<Article> findAll() { // 테이블에 저장되어있는 모든 데이터 조회
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    /* 특정 아이디의 글을 수정하는 update */
    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+ id));

        article.update(request.getTitle(),request.getContent()); // request dto 를 통해 업데이트 하기

        return article;
    }

}
