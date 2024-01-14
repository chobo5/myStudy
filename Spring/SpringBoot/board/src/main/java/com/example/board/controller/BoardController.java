package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/writeFrom")
    public String writeForm() {
        //로그인한 사용자만 글을 써야한다. 로그인을 하지 않았다면 리스트보기로 이동시킨다.
        //세션에서 로그인한 정보를 읽어드린다.
        //로그인한 사용자라면 글쓰기 화면으로 이동한다.
        return "writeForm";
    }

    @PostMapping("/write")
    public String write(@RequestParam("title") String title, @RequestParam("content") String content) {
        //로그인한 회원정보, 제목, 내용을 저장한다.
        System.out.println("title: " + title);
        System.out.println("content: " + content);
        return "redirect:/";
    }


    //삭제한다. 관리자는 모든글 삭제가능

    //수정한다.
}
