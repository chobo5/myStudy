package com.example.board.controller;

import com.example.board.dto.Board;
import com.example.board.dto.LoginInfo;
import com.example.board.service.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller //HTTP요청을 받아서 응답을 하는 컴포넌, 스프링 부트가 자동으로 bean으로 생성
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    //게시물 목록을 보여줌
    //컨트롤러의 메소드가 리턴하는 문자열을 템플릿 이름이다.
    //http://localhost:8080/ ---> "list"라는 이름의 템플릿을 사용(포워딩)하여 화면에 출력
    @GetMapping("/")
    public String list(@RequestParam(name="page", defaultValue = "1") int page,
                       HttpSession session,
                       Model model) { //두 파라미터는 spring이 자동으로 주입
        //게시물 목록을 읽어온다. 페이징 처리한다.
        LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
        model.addAttribute("loginInfo", loginInfo); //템플릿에게


        int totalCount = boardService.getTotalCount();
        int pageCount = totalCount % 10 == 0 ? totalCount / 10 : totalCount / 10 + 1;
        int currentPage = page;
        List<Board> list = boardService.getBoards(page);
//        System.out.println("totlaCount: " + totalCount);
//        for (Board board : list) {
//            System.out.println(board);
//        }
        model.addAttribute("list", list);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("currentPage", currentPage);
        return "list";
    }

    @GetMapping("/board")
    public String board(@RequestParam("boardId") int boardId, Model model) {
        System.out.println("id: " + boardId);
        //id에 해당하는 게시물을 읽어온다.
        //id에 해당하는 게시물의 조회수도 1더해준
        Board board = boardService.getBoard(boardId);
        model.addAttribute("board", board);
        return "board";
    }

    @GetMapping("/writeForm")
    public String writeForm(HttpSession session, Model model) {
        //로그인한 사용자만 글을 써야한다. 로그인을 하지 않았다면 리스트보기로 이동시킨다.
        //세션에서 로그인한 정보를 읽어드린다.
        //로그인한 사용자라면 글쓰기 화면으로 이동한다.
        LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
        if (loginInfo == null) { //세션에 로그인 정보가 없으면 /loginForm으로 이동
            return "redirect:/loginForm";
        }

        model.addAttribute("loginInfo", loginInfo);

        return "writeForm";
    }

    @PostMapping("/write")
    public String write(@RequestParam("title") String title,
                        @RequestParam("content") String content,
                        HttpSession session) {
        //로그인한 회원정보, 제목, 내용을 저장한다.
        LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
        if (loginInfo == null) { //세션에 로그인 정보가 없으면 /loginForm으로 이동
            return "redirect:/loginForm";
        };
        boardService.addBoard(loginInfo.getUserId(), title, content);
        return "redirect:/";
    }


    //삭제한다. 관리자는 모든글 삭제가능
    @GetMapping("/delete")
    public String delete(@RequestParam("boardId") int boardId,
                         HttpSession session) {
        LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
        if (loginInfo == null) {
            return "redirect:/loginform";
        }

        //loginInfo.getUserId()에 해당하는 id를 가진 유저가 삭제한다면 삭제
        boardService.delete(loginInfo.getUserId(), boardId);
        return "redirect:/";
    }

    //수정한다.
}
