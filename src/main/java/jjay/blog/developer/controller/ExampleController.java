package jjay.blog.developer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Getter;
import lombok.Setter;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ExampleController {

    @GetMapping("/thymeleaf/example")
    public String thymeleafExample(Model model) { //뷰로 데이터를 넘겨주는 모델 객체
        Person examplePerson = new Person();
        examplePerson.setId(1L);
        examplePerson.setName("J-Jay");
        examplePerson.setAge(19);
        examplePerson.setHobbies(List.of("운동", "코딩"));

        model.addAttribute("person", examplePerson); //Person 객체 저장
        model.addAttribute("today", LocalDate.now());

        return "example"; //example.html 뷰 조회
    }

    @Setter
    @Getter
    class Person {
        private Long id;
        private String name;
        private int age;
        private List<String> hobbies;
    }
}