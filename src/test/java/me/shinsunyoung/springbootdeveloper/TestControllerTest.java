package me.shinsunyoung.springbootdeveloper;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.result.*;
@SpringBootTest // 테스트용 애플리케이션 컨텍스트 생성
@AutoConfigureMockMvc // MockMvc 생성 및 자동 구성 // MockMVC: 테스트용 mvc 환경을 만들어줌
class TestControllerTest {


    
    @Autowired
    protected MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext context;
    
    @Autowired
    private MemberRepository memberRepository;
    
    @BeforeEach // 테스트 실행 전
    public void mockMvcSetup() { // MockMvc 설정
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @AfterEach
    public void cleanUp() { // member 테이블 데이터 모두 삭제
        memberRepository.deleteAll();
    }

    /*  TestController 로직 테스트 코드 */

    @DisplayName("getAllMembers: 아티클 조회에 성공한다.")
    @Test
    public void getAllMembers() throws Exception {
        // given: 테스트 실행을 준비하는 단계: 멤버를 저장
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L,"홍길동"));

        // when: 테스트를 진행하는 단계: 멤버 리스트를 조회하는 API 호출
        final ResultActions result = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));
        // perform() 요청을 전송하는 메서드, 결과로 ResultActions 객체를 받음
        // accept() 어떤 반환 타입으로 받을지 결정하는 메서드
        // andExpect() 응답을 검증
        //

        // then: 테스트 결과를 검증하는 단계: 응답코드 200 , 반환받은 값중에 0번째 요쇼의 id와  name이 저장된 값과 일치하는가
        result.andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));

        // jsonPath()는 josn응답값의 값을 가져오는 역할을 하는 메서드 저장된 값과 같은지 비교
    }
}