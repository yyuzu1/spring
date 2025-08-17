package com.boot.example.controller;

import com.boot.example.domain.ExampleDTO;
import com.boot.example.domain.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1. 제일 처음 컨트롤러 어노테이션 하여 설정 작업
// 2.  그 다음 공통 매핑 잡음
@Controller
@RequestMapping("/example")
public class ExampleController {

    // 3. 그다음에 메서드별 접근 방법에 따른 매핑 잡음
    @GetMapping("/exam01")
    public String example(Model model) {
        model.addAttribute("data", "현재 페이지에 출력 데이터");
        return "/example/exam01";
        //템플릿 엔진을 타임리프로 설정했기 때문에 (리턴값에서) .html을 찾음
    }

    @GetMapping("/form")
    public String form() {
        return "example/form";
    }

    /*요청 방법 : http://localhost:8080/example/exam03?name=홍길동&age=25 */
    @GetMapping("/exam03")
    public String exam03(@RequestParam String name, @RequestParam(required = false, defaultValue = "0") int age, Model model){
//    public String exam03(@RequestParam String name, @RequestParam int age, Model model){
        // RequestParam int하면 Integer parseInt로 받아오는데,
        // 값을 입력 안 할 경우, 0을 인트로 또 변환하니 에러 발생
        // 그래서 나이를 필수 값으로 받을 거 아니면 위의 다폴트벨류 방식 사용
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        return "example/exam03";
    }

    /*참고 : @ModelAttribute는 전달받은 파라미터를 Model에 담아서 전달하도록 할 때 사용하는 어노테이션이다.*/
    @PostMapping("/exam04")
//    public String exam04(@ModelAttribute SampleDTO dto, Model model){
    public String exam04(@ModelAttribute SampleDTO dto) {
//        model.addAttribute("dto",dto);
        return "example/exam04";
    }

    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("data1","뷰에 출력할 데이터");
        model.addAttribute("data2","뷰에 출력할 <strong>데이터</strong>");

        model.addAttribute("number",3);

        model.addAttribute("data","Spring!");

        model.addAttribute("auth","admin");

        ExampleDTO exampleDTO = new ExampleDTO();
        exampleDTO.setName("홍길동");
        exampleDTO.setAge(38);
        exampleDTO.setEmail("javauser@naver.com");
        model.addAttribute("exampleDTO",exampleDTO);

        List<ExampleDTO> list = new ArrayList<>();
        list.add(new ExampleDTO("김철수",26,"springuser@naver.com"));
        list.add(new ExampleDTO("한늘봄",32,"jsp1234@gmail.com"));
        model.addAttribute("list",list);

        Map<Integer, ExampleDTO> map = new HashMap<>();
        map.put(1, new ExampleDTO("김미숙",30,"javauser@naver.com"));
        map.put(2,new ExampleDTO("조한미",23,"bootuser@naver.com"));
        model.addAttribute("map",map);

        model.addAttribute("localDateTime", LocalDateTime.now());

        return "example/test";
    }

    @GetMapping("/exam02")
    public String exam01(Model model,
                         @RequestParam(required = false, defaultValue = "java") String language,
                         @RequestParam(required = false) String word) {
        model.addAttribute("language",language);
        model.addAttribute("word", word);

        return "example/exam02";
    }

    @GetMapping("/exam05")
    @ResponseBody
    public String exam05(){
        return "Data 전송";
    }
}
