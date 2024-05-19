package me.shinsunyoung.springbootdeveloper;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본생성자 protected인
@AllArgsConstructor
@Getter
@Entity // 엔티티로 지정 // Member class와 실제 db table 매칭 // 속성중 name = 을 사용하면 그 테이블 이름과 매핑되고 아니면 클래스 이름과 같은 테이플 매핑
public class Member { // table 생성
    @Id // id 필드를 기본키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키의 생성방식 결정 // 기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false) // 데이터 베이스의 컬럼과 필드를 매핑 // name = 을 설정하지 않으면 필드 이름으로 지정
    private Long id; // DB table의 id 컬럼과 매칭

    @Column(name = "name", nullable = false) // name이라는 notnull 컬럼과 매핑 
    private String name; // DB table의 name 컬럼과 매칭

    public void changeName(String name) {
        this.name = name;
    }
}
