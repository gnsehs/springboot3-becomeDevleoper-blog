package me.shinsunyoung.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
// DB 에서 데이터를 가져오는 퍼시스턴트 계층
@Repository
public interface MemberRepository extends JpaRepository<Member,Long> { // JpaRepository를 상속받을때
    // 엔티티(Member)와 엔티티의 기본키 타입(Long)를 인수로 넣어준다.

    Optional<Member> findByName(String name);
}

/*
리포지터리는 엔티티에 있는 데이터들을 조회하거나 저장 변경 삭제를 할 때 사용하는 인터페이스

MemberRepository에서 Member로 조회
 */