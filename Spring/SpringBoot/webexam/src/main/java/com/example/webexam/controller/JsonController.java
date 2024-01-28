package com.example.webexam.controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //응답이 데이터
public class JsonController {
    @GetMapping("/hello.json")
    public Hello hello() {
        Hello hello = new Hello();
        hello.setMessage("Hello World!");
        hello.setCount(10);
        return hello; //Spring이
        // 자동으로 json으로 변경
    }
}

@Data
class Hello {
    private String message;
    private int count;

}