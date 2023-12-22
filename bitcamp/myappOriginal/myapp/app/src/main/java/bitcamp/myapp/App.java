package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuItem;
import bitcamp.myapp.handler.assignment.*;
import bitcamp.myapp.handler.board.*;
import bitcamp.myapp.handler.member.*;
import bitcamp.myapp.vo.Assignment;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

public class App {

  public static void main(String[] args) {
    Prompt prompt = new Prompt(System.in);
    MenuGroup mainMenu = new MenuGroup("메인");

    ArrayList<Assignment> assignmentRepository = new ArrayList<>();
    ArrayList<Board> boardRepository = new ArrayList<>();
    ArrayList<Member> memberRepository = new ArrayList<>();
    ArrayList<Board> greetingRepository = new ArrayList<>();

    MenuGroup assignmentMenu = new MenuGroup("과제");
    assignmentMenu.add(new MenuItem("등록", new AssignmentAddHandler(prompt, assignmentRepository)));
    assignmentMenu.add(new MenuItem("조회", new AssignmentViewHandler(prompt, assignmentRepository)));
    assignmentMenu.add(new MenuItem("수정", new AssignmentModifyHandler(prompt, assignmentRepository)));
    assignmentMenu.add(new MenuItem("삭제", new AssignmentDeleteHandler(prompt, assignmentRepository)));
    assignmentMenu.add(new MenuItem("목록", new AssignmentListHandler(prompt, assignmentRepository)));
    assignmentMenu.add(new MenuItem("이전"));
    mainMenu.add(assignmentMenu);

    MenuGroup boardMenu = new MenuGroup("게시판");
    boardMenu.add(new MenuItem("등록", new BoardAddHandler(prompt, boardRepository)));
    boardMenu.add(new MenuItem("조회", new BoardViewHandler(prompt, boardRepository)));
    boardMenu.add(new MenuItem("수정", new BoardModifyHandler(prompt, boardRepository)));
    boardMenu.add(new MenuItem("삭제", new BoardDeleteHandler(prompt, boardRepository)));
    boardMenu.add(new MenuItem("목록", new BoardListHandler(prompt, boardRepository)));
    boardMenu.add(new MenuItem("이전"));
    mainMenu.add(boardMenu);

    MenuGroup helpMenu = new MenuGroup("도움말");
    helpMenu.add(new MenuItem("등록"));
    helpMenu.add(new MenuItem("이전"));
    mainMenu.add(helpMenu);

    MenuGroup memberMenu = new MenuGroup("회원 관리");
    memberMenu.add(new MenuItem("등록", new MemberAddHandler(prompt, memberRepository)));
    memberMenu.add(new MenuItem("조회", new MemberViewHandler(prompt, memberRepository)));
    memberMenu.add(new MenuItem("수정", new MemberModifyHandler(prompt, memberRepository)));
    memberMenu.add(new MenuItem("삭제", new MemberDeleteHandler(prompt, memberRepository)));
    memberMenu.add(new MenuItem("목록", new MemberListHandler(prompt, memberRepository)));
    memberMenu.add(new MenuItem("이전"));
    mainMenu.add(memberMenu);

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
