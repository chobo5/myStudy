package com.example.springweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class HelloController {
    @Autowired
    DataSource dataSource;  //스프링이 Bean으로 관리되는 개체를 자동으로 주입
    @GetMapping("/hello") // /hello요청이 오면 해당 메소드를 실행하라.
//    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("Hello Spring MVC");
//        out.close();
        //이해를 위해 일부러 Servlet과 유사하게 만든 메서드, 실제로 이렇게 사용하진 않는다.


    // URL을 처리해주는 컨트롤러의 메서드가 hello를 리턴하면 hello.jsp로 포워딩하고 싶다.
    public String hello() throws IOException {
        //로직을수행
        return "hello"; //hello.jsp로 포워딩하고싶음
        //Check your ViewResolver setup! 에러 발생
        //WebMvcConfigurer를 구현하고 있는 파일에서 설정해준다(WebConfig)
    }
}
