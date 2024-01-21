package com.example.board.controller;

import com.example.board.dto.LoginInfo;
import com.example.board.dto.User;
import com.example.board.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/userRegForm")
    public String userRegForm() {
        return "userRegForm";
    }

    @PostMapping("/userReg")
    public String userReg(@RequestParam("name") String name,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password,
                          HttpSession httpSession) { //Spring이 자동으로 HttpSession객체를 넣어준다.
        //이름, 이메일, 암호가 여기로 전달됨
        System.out.printf("name: %s, email: %s, password: %s\n", name, email, password);
        userService.addUser(name, email, password);

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

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpSession httpSession) { //Spring이 자동으로 HttpSession객체를 넣어준다.
        //email에 해당하는 회원정보를 읽어온후, 아이디, 암호가 일치한다면 세션에 회원정보를 저장한다.
        System.out.printf("email: %s, password: %s\n", email, password);

        try {
            User user = userService.getUser(email);
            if (user.getPassword().equals(password)) {
                System.out.println("암호가 일치합니다.");
                LoginInfo loginInfo = new LoginInfo(user.getUserId(), user.getEmail(), user.getName());

                //권한 정보를 읽어와서 loginInfo에 추가한다.
                List<String> roles = userService.getRoles(user.getUserId());
                loginInfo.setRoles(roles);

                httpSession.setAttribute("loginInfo", loginInfo); //세션에 로그인정보 저장(키:정보)
                System.out.println("세션에 로그인 정보 저장");
            } else {
                throw new RuntimeException("암호 불일치");
            }
            System.out.println(user);
        } catch (Exception e) {
            return "redirect:/loginform?error=true";
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        //세션에서 회원정보를 삭제한다.
        httpSession.removeAttribute("loginInfo");
        return "redirect:/";
    }
}