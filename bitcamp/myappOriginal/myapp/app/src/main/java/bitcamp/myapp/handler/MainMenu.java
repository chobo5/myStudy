package bitcamp.myapp.handler;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuGroup;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public class MainMenu implements Menu {

  static final String APP_TITLE =
      AnsiEscape.ANSI_BOLD_RED
          + "[과제관리 시스템]"
          + AnsiEscape.ANSI_CLEAR;
  static final String[] MENUS = {
      "1. 과제",
      "2. 게시글",
      "3. 회원",
      "4. 가입인사",
      "5. 도움말",
      "6. 계산기",
      AnsiEscape.ANSI_RED + "0. 종료" + AnsiEscape.ANSI_CLEAR
  };

  // 의존 객체(Dependency Object ==> dependency);
  // - 클래스가 작업을 수행할 때 사용하는 객체
  Prompt prompt;

  public MainMenu(Prompt prompt) {
    this.prompt = prompt;
  }

  static void printMenu() {
    System.out.println(APP_TITLE);
    System.out.println();
    for (String menu : MENUS) {
      System.out.println(menu);
    }
  }

  public void execute(Prompt prompt) {

    Menu boardMenu = new MenuGroup("게시판");
    Menu greetingMenu = new MenuGroup("가입인사");
    Menu assignmentMenu = new MenuGroup("과제");
    Menu memberMenu = new MenuGroup("회원");
    Menu helpMenu = new MenuGroup("도움말");

    printMenu();

    while (true) {
      String input = this.prompt.input("메인> ");

      switch (input) {
        case "1":
          assignmentMenu.execute(prompt);
          break;
        case "2":
          boardMenu.execute(prompt);
          break;
        case "3":
          memberMenu.execute(prompt);
          break;
        case "4":
          greetingMenu.execute(prompt);
          break;
        case "5":
          System.out.println("도움말입니다.");
          break;
        case "0":
          System.out.println("종료합니다.");
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }

  @Override
  public String getTitle() {
    return null;
  }
}
