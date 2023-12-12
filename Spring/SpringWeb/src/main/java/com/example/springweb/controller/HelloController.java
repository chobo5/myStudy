package com.example.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class HelloController {
    @GetMapping("/hello") // /hello요청이 오면 해당 메소드를 실행하라.
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Hello Spring MVC");
        out.close();
        //이해를 위해 일부러 Servlet과 유사하게 만든 메서드, 실제로 이렇게 사용하진 않는다.
    }
}
