package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuItem;
import bitcamp.myapp.handler.assignment.*;
import bitcamp.myapp.handler.board.*;
import bitcamp.myapp.handler.member.*;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {
    Prompt prompt = new Prompt(System.in);
    MenuGroup mainMenu = new MenuGroup("메인");
    ObjectRepository objectRepository = new ObjectRepository();
    AssignmentRepository assignmentRepository = new AssignmentRepository();
    MemberRepository memberRepository = new MemberRepository();

    MenuGroup assignmentMenu = new MenuGroup("과제");
    assignmentMenu.add(new MenuItem("등록", new AssignmentAddHandler(prompt, assignmentRepository)));
    assignmentMenu.add(new MenuItem("조회", new AssignmentViewHandler(prompt, assignmentRepository)));
    assignmentMenu.add(new MenuItem("수정", new AssignmentModifyHandler(prompt, assignmentRepository)));
    assignmentMenu.add(new MenuItem("삭제", new AssignmentDeleteHandler(prompt, assignmentRepository)));
    assignmentMenu.add(new MenuItem("목록", new AssignmentListHandler(assignmentRepository)));
    assignmentMenu.add(new MenuItem("이전"));
    mainMenu.add(assignmentMenu);

    MenuGroup boardMenu = new MenuGroup("게시판");
    boardMenu.add(new MenuItem("등록", new BoardAddHandler(prompt, objectRepository)));
    boardMenu.add(new MenuItem("조회", new BoardViewHandler(prompt, objectRepository)));
    boardMenu.add(new MenuItem("수정", new BoardModifyHandler(prompt, objectRepository)));
    boardMenu.add(new MenuItem("삭제", new BoardDeleteHandler(prompt, objectRepository)));
    boardMenu.add(new MenuItem("목록", new BoardListHandler(objectRepository)));
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
    memberMenu.add(new MenuItem("목록", new MemberListHandler(memberRepository)));
    memberMenu.add(new MenuItem("이전"));
    mainMenu.add(memberMenu);


    mainMenu.execute(prompt);
    prompt.close();
  }
}
