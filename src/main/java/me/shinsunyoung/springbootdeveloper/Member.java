package me.shinsunyoung.springbootdeveloper;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Member { // table 생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id; // DB table의 id 컬럼과 매칭

    @Column(name = "name", nullable = false)
    private String name; // DB table의 name 컬럼과 매칭
}
