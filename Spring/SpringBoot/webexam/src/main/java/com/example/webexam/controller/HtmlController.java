package com.example.webexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //html을 응답하는 Controller
public class HtmlController {
    @GetMapping("/hello")
    @ResponseBody
    public String index() {
        return "<html><body><h1>Hello World!</h1></body></html>";
    }
}
