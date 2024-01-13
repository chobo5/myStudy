package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @GetMapping("/userRegForm")
    public String userRegForm() {
        return "userRegForm";
    }

    @PostMapping("/userReg")
    public String userReg(@RequestParam("name") String name,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password) {
        //이름, 이메일, 암호가 여기로 전달됨
        System.out.printf("name: %s, email: %s, password: %s\n", name, email, password);

        return "redirect:/welcome"; //브라우저에게 자동으로 http://localhost:8080/welcome으로 이동
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/loginform")
    public String loginform() {
        return "loginform";
    }

    @GetMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        //email에 해당하는 회원정보를 읽어온후, 아이디, 암호가 일치한다면 세션에 회원정보를 저장한다.
        System.out.printf("email: %s, password: %s\n", email, password);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        //세션에서 회원정보를 삭제한다.
        return "redirect:/";
    }
}