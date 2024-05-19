package me.shinsunyoung.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;


import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // 테스트를 위한 설정을 제공하며, 자동으로 데이터베이스에 대한 트랜잭션 관리를 설정함 // 서비스 코드에서 업데이트 기능을 사용하려면 @Transactional 이용해야함
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Sql("/insert-members.sql") // 테스트를 실행하기 전에 SQL 스트립트를 실행시킬수 있음
    @Test
    void getAllMembers() {
        // when
        // List<Member> members = memberRepository.findAll();
        // Member member = memberRepository.findById(2L).get();
        // Member member = memberRepository.findByName("C").get();
        // then
        // Assertions.assertThat(members.size()).isEqualTo(3);
        // Assertions.assertThat(member.getName()).isEqualTo("B");
        // Assertions.assertThat(member.getId()).isEqualTo(3L);




    }

//    @Test
//    void saveMember() {
//        // given
//        Member member = new Member(1L,"A"); // 새로운 A 멤버 객체 준비
//
//        // when
//        memberRepository.save(member); // INSERT INTO ... 실제 저장
//
//        // then
//        assertThat(memberRepository.findById(1L).get().getName()).isEqualTo("A");
//
//
//
//    }
//
//    @Test
//    void saveMembers() {
//        List<Member> members = List.of(new Member(2L,"B"),new Member(3L,"C"));
//        // when
//        memberRepository.saveAll(members);
//        // then
//        assertThat(memberRepository.findAll().size()).isEqualTo(2);
//    }


    @Sql("/insert-members.sql")
    @Test
    void deleteMemberById() {
        // when
        memberRepository.deleteById(2L);
        // then
        assertThat(memberRepository.findById(2L).isEmpty()).isTrue(); // 없다는게 트루
    }
    @Sql("/insert-members.sql")
    @Test
    void deleteALL() {
        // when
        memberRepository.deleteAll();
        // then
        assertThat(memberRepository.findAll().size()).isZero();
    }

    @Sql("/insert-members.sql")
    @Test
    void update() {
        // given
        Member member = memberRepository.findById(2L).get();

        // when
        member.changeName("BC");
        // then
        assertThat(memberRepository.findById(2L).get().getName()).isEqualTo("BC");
    }

    @AfterEach
    public void cleanUp() {
        memberRepository.deleteAll();
    }


}