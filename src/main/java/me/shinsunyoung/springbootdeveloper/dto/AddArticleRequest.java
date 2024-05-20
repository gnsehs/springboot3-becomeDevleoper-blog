package me.shinsunyoung.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.Article;
/* DTO: 계층끼리 데이터를 교환하기 위해 사용하는 객체 (단순하게 데이터를 옮기기 위해 사용하는 전달자 역할) */
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity() { // 빌더 패턴을 이용해 DTO 를 엔티티로 만들어주는 메서드 추후에 글을 추가할 때 저장할 엔티티로 변환
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
