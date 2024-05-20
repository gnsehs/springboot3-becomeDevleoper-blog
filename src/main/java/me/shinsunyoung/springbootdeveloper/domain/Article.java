package me.shinsunyoung.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // 엔티티
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본생성자를 별도 코드 없이 생성
public class Article {
    
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동 1 증가
    @Column(name = "id", updatable = false)
    private Long id;
    
    @Column(name = "title", nullable = false) // not null
    private String title;
    
    @Column(name = "content", nullable = false)
    private String content;
    /*
    Bulider: 롬복에서 지원하는 애너테이션 빌더 패턴 방식으로 객체를 생성 할 수 있음.
    Article.builder().title().content().build();
     */
    @Builder // 빌더 패턴으로 객체 생성
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /*
    애너 테이션으로 대체
     */
//    protected Article() { // 기본 생성자
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getContent() {
//        return content;
//    }
}
