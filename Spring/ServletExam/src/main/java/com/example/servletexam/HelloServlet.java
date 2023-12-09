package com.example.servletexam;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Enumeration;

@WebServlet(name = "helloServlet", value = "/hello-servlet") //servlet path를 설정
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        System.out.println("init() 호출");
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //요청 정보
        //1. GET /hello-servlet
        //2. 헤더들
        //3. 빈줄

        //Enumeration = Iterator와 비슷
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.printf(headerName + " " + request.getHeader(headerName));
        }

        //브라우저에게 보내는 컨텐츠의 타입을 알려줌
        response.setContentType("text/html");

        //응답의 Body에 쓰기위한 PrintWriter를 받아온다.
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}