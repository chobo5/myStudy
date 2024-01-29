package com.example.webexam.controller;

import com.example.webexam.controller.request.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/example")
public class ExampleController {
    @GetMapping("/1")
    public String example1() {
        return "example1";
    }

    @GetMapping("/2")
    public String example2(HttpServletRequest request) {
        System.out.println(request);
        return "example2";
    }

    @PostMapping("/3")
    public String example3(@RequestParam(name = "name", required = true) String name,
                           @RequestParam(name = "email", required = false, defaultValue = "empty_email") String email) {
        //form으로 부턴 넘어 값을 받는방법
        //방법 1. HttpServletRequest 이용
//        System.out.println(request.getParameter("name"));
//        System.out.println(request.getParameter("email"));

        //방법 2. @RequestPara 이용
        System.out.println(name + " " + email);

        return "example3";
    }


    //@RestController는 보통 브라우저에서 동작하는 JavaScript가 호출한다.
    //JavaScript가 호출할때 json데이터를 post방식으로 body에 담아 전송한다
    @PostMapping("/4")
    public User example4(@RequestBody User user) {
        System.out.println(user);
        user.setRandom(new Random().nextInt(100));
        return user;
    }

    @GetMapping("pathexam/{id}")
    public String pathExam(@PathVariable(name = "id") String id) {
        System.out.println(id);
        return "pathexam";
    }

    @GetMapping("/headerexam")
    public String headerExam(@RequestHeader("User-Agent") String userAgentValue) {
        System.out.println(userAgentValue);
        return "headerexam";

    }
}
