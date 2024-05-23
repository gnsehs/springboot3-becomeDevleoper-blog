package me.shinsunyoung.springbootdeveloper.domain;

import jakarta.el.ArrayELResolver;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@EntityListeners(ArrayELResolver.class) // 엔티티의 생성 및 수정 시간을 자동으로 감시하고 기록
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

    @CreatedDate // 엔티티가 생성될 때 시간을 컬럼에 저장
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate // 엔티티가 수정될때 마지막으로 수정된 시간 저장
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @Builder // 빌더 패턴으로 객체 생성
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
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
