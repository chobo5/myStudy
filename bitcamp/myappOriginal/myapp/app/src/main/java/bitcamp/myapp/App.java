package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuItem;
import bitcamp.myapp.menu.*;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {
    Prompt prompt = new Prompt(System.in);
    MenuGroup mainMenu = new MenuGroup("메인");
    BoardRepository boardRepository = new BoardRepository();

    MenuGroup assignmentMenu = new MenuGroup("과제");
    assignmentMenu.add(new MenuItem("등록"));
    assignmentMenu.add(new MenuItem("조회"));
    assignmentMenu.add(new MenuItem("수정"));
    assignmentMenu.add(new MenuItem("삭제"));
    assignmentMenu.add(new MenuItem("목록"));
    assignmentMenu.add(new MenuItem("이전"));
    mainMenu.add(assignmentMenu);

    MenuGroup boardMenu = new MenuGroup("게시판");
    boardMenu.add(new MenuItem("등록", new BoardAddHandler(prompt, boardRepository)));
    boardMenu.add(new MenuItem("조회", new BoardViewHandler()));
    boardMenu.add(new MenuItem("수정", new BoardModifyHandler()));
    boardMenu.add(new MenuItem("삭제", new BoardDeleteHandler()));
    boardMenu.add(new MenuItem("목록", new BoardListHandler(boardRepository)));
    boardMenu.add(new MenuItem("이전"));
    mainMenu.add(boardMenu);

    MenuGroup helpMenu = new MenuGroup("도움말");
    helpMenu.add(new MenuItem("등록"));
    helpMenu.add(new MenuItem("이전"));
    mainMenu.add(helpMenu);

    MenuGroup memberMenu = new MenuGroup("회원 관리");
    memberMenu.add(new MenuItem("등록"));
    memberMenu.add(new MenuItem("조회"));
    memberMenu.add(new MenuItem("수정"));
    memberMenu.add(new MenuItem("삭제"));
    memberMenu.add(new MenuItem("목록"));
    memberMenu.add(new MenuItem("이전"));
    mainMenu.add(memberMenu);


    mainMenu.execute(prompt);
    prompt.close();
  }
}
