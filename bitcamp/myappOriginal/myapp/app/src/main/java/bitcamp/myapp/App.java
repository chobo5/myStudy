package bitcamp.myapp;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuItem;
import bitcamp.myapp.handler.assignment.*;
import bitcamp.myapp.handler.board.*;
import bitcamp.myapp.handler.member.*;
import bitcamp.myapp.vo.Assignment;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.List;
import bitcamp.util.Prompt;

import bitcamp.util.ArrayList;
import bitcamp.util.Stack;

public class App {

  public static void main(String[] args) {
    Prompt prompt = new Prompt(System.in);

    MenuGroup mainMenu = MenuGroup.getInstance("메인");

    List<Assignment> assignmentRepository = new ArrayList<>();
    List<Board> boardRepository = new ArrayList<>();
    List<Member> memberRepository = new ArrayList<>();
    List<Board> greetingRepository = new ArrayList<>();


    MenuGroup assignmentMenu = mainMenu.addGroup("과제");
    assignmentMenu.addItem("등록", new AssignmentAddHandler(prompt, assignmentRepository));
    assignmentMenu.addItem("조회", new AssignmentViewHandler(prompt, assignmentRepository));
    assignmentMenu.addItem("수정", new AssignmentModifyHandler(prompt, assignmentRepository));
    assignmentMenu.addItem("삭제", new AssignmentDeleteHandler(prompt, assignmentRepository));
    assignmentMenu.addItem("목록", new AssignmentListHandler(prompt, assignmentRepository));



    MenuGroup boardMenu = mainMenu.addGroup("게시판");
    boardMenu.addItem("등록", new BoardAddHandler(prompt, boardRepository));
    boardMenu.addItem("조회", new BoardViewHandler(prompt, boardRepository));
    boardMenu.addItem("수정", new BoardModifyHandler(prompt, boardRepository));
    boardMenu.addItem("삭제", new BoardDeleteHandler(prompt, boardRepository));
    boardMenu.addItem("목록", new BoardListHandler(prompt, boardRepository));


    MenuGroup helpMenu = mainMenu.addGroup("도움말");


    MenuGroup memberMenu = mainMenu.addGroup("회원 관리");
    memberMenu.addItem("등록", new MemberAddHandler(prompt, memberRepository));
    memberMenu.addItem("조회", new MemberViewHandler(prompt, memberRepository));
    memberMenu.addItem("수정", new MemberModifyHandler(prompt, memberRepository));
    memberMenu.addItem("삭제", new MemberDeleteHandler(prompt, memberRepository));
    memberMenu.addItem("목록", new MemberListHandler(prompt, memberRepository));

    while(true) {
      try {
        mainMenu.execute(prompt);
        break;
      } catch (Exception e) {
        System.out.println("오류가 발생했습니다. 프로그램을 재시작합니다.");
      }
    }

    prompt.close();
  }
}
