package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //HTTP요청을 받아서 응답을 하는 컴포넌, 스프링 부트가 자동으로 bean으로 생성
public class BoardController {
    //게시물 목록을 보여줌
    //컨트롤러의 메소드가 리턴하는 문자열을 템플릿 이름이다.
    //http://localhost:8080/ ---> "list"라는 이름의 템플릿을 사용(포워딩)하여 화면에 출력
    @GetMapping("/")
    public String list() {
        //게시물 목록을 읽어온다. 페이징 처리한다.
        return "list";
    }

    @GetMapping("/board")
    public String board(@RequestParam("id") int id) {
        System.out.println("id: " + id);
        //id에 해당하는 게시물을 읽어온다.
        //id에 해당하는 게시물의 조회수도 1더해준
        return "board";
    }


    //삭제한다. 관리자는 모든글 삭제가능

    //수정한다.
}
