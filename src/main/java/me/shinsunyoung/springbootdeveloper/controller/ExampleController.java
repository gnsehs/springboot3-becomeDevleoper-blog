package me.shinsunyoung.springbootdeveloper.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ExampleController {
    
    @GetMapping("/thymeleaf/example")
    public String thymeleafExample(Model model) { // 뷰로 데이터를 넘겨주는 모델 객체
        Person examplePerson = new Person();
        examplePerson.setId(1L);
        examplePerson.setName("한도훈");
        examplePerson.setAge(11);
        examplePerson.setHobbies(List.of("운동", "독서"));
        
        model.addAttribute("person",examplePerson); // person 객체 지정
        model.addAttribute("today", LocalDate.now());
        
        
        return "example"; // example.html 이라는 뷰 조회 // 뷰의 이름을 반환
        // @Controller를 보고 반환하는 값의 이름을 가진 뷰의 파일을 찾으라는 것이구나 라고 생각
    }
}
/*
model 객체는 뷰 즉 HTML 쪽으로 값을 넘겨주는 객체
모델 객체는 따로 생성할 필요 없다.

addAttribute() 로 모델에 값을 지정한다.
 */
@Getter
@Setter
class Person {
    private Long id;
    private String name;
    private int age;
    private List<String> hobbies;
}