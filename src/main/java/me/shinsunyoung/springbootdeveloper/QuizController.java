package me.shinsunyoung.springbootdeveloper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuizController {

    @GetMapping("/quiz") // 요청 파라미터의 키가 code이면 int 자료형의 code변수와 매핑됨 code 값에따라 다른 응답
    public ResponseEntity<String> quiz(@RequestParam("code") int code) {
        switch (code) {
            case 1:
                return ResponseEntity.created(null).body("Created!");
            case 2:
                return ResponseEntity.badRequest().body("Bad Request!");
            default:
                return ResponseEntity.ok().body("OK!");

        }
    }

    @PostMapping("/quiz") // quiz 패스로 post요청이 온다면, 요청값을 Code라는 객체로 매핑한 다음 value에 따라 다른 응답
    public ResponseEntity<String> quiz2(@RequestBody Code code) {
        switch (code.value()) {
            case 1:
                return ResponseEntity.status(403).body("Forbidden!");
            default:
                return ResponseEntity.ok().body("OK!");
        }
    }


    record Code(int value) {}; // 데이터 전달을 목적으로 하는 객체를 생성, 파라미터로 필드를줌, 필드() = getter
}
