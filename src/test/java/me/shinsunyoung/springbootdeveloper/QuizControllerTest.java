package me.shinsunyoung.springbootdeveloper;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class QuizControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper; // 객체와 JSON 간의 변환을 처리

    @BeforeEach
    public void mockMvcSetup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @DisplayName("quiz(): GET /quiz?code=1 이면 응답코드는 201, 응답 본문은 Created!를 리턴한다.")
    @Test
    public void getQuiz1() throws Exception {

        final String url = "/quiz";

        // final ResultActions result = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));

        final ResultActions result = mockMvc.perform(get(url).param("code","1"));

        //     result.andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(savedMember.getId()))
        //                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
        result.andExpect(status().isCreated()).andExpect(content().string("Created!"));

    }

    @DisplayName("quiz(): GET /quiz?code=2 이면 응답코드는 400, 응답 본문은 Bad Request!를 리턴한다.")
    @Test
    public void getQuiz2() throws Exception {
        final String url = "/quiz";

        final ResultActions result = mockMvc.perform(get(url).param("code","2"));

        result.andExpect(status().isBadRequest()).andExpect(content().string("Bad Request!"));
    }

    @DisplayName("quiz(): POST /quiz?code=1 이면 응답코드는 403, 응답 본문은 Forbidden!을 리턴한다.")
    @Test
    public void postQuiz1() throws Exception {
        final String url = "/quiz";

        final ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new QuizController.Code(1))));

        result.andExpect(status().isForbidden()).andExpect(content().string("Forbidden!"));
    }

    @DisplayName("quiz(): POST /quiz?code=13 이면 응답코드는 200, 응답 본문은 OK!을 리턴한다.")
    @Test
    public void postQuiz2() throws Exception {
        final String url = "/quiz";

        final ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON) // Json 형식으로 데이터를 보낸다고 명시
                .content(objectMapper.writeValueAsString(new QuizController.Code(13)))); // code 13을 json 형식의 string으로 만듦
        // 객체와 json간의 변환을 처리해줌 json 형태의 문자열로 객체가 변환됨

        result.andExpect(status().isOk()).andExpect(content().string("OK!"));
    }


}