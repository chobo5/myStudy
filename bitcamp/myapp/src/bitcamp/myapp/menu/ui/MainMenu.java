package bitcamp.myapp.menu.ui;

import bitcamp.myapp.menu.MenuService;
import bitcamp.util.Prompt;

public class MainMenu {
    private Prompt prompt;
    private MenuService menuService;

    public MainMenu(Prompt prompt) {
        this.prompt = prompt;
        this.menuService = new MenuService(0);
    }
    private final String[] MAIN_MENUS = {"과제관리 시스템", "1.과제", "2.게시글", "3.회원관리", "4.가입인사", "5.도움말", "0.종료"};
    public void execute() {
        AssignmentMenu assignmentMenu = new AssignmentMenu("과제", this.prompt);
        BoardMenu boardMenu = new BoardMenu("게시", prompt);
        BoardMenu greetingBoardMenu = new BoardMenu("가입인사", this.prompt);
        MemberMenu memberMenu = new MemberMenu("회원관리", this.prompt);

        menuService.showMenu(MAIN_MENUS);
        while (true) {
            String input = prompt.getUserInput("메인", "");
            switch (input) {
                case "1":
                    assignmentMenu.execute();
                    break;
                case "2":
                    boardMenu.execute();
                    break;
                case "3":
                    memberMenu.execute();
                case "4":
                    greetingBoardMenu.execute();
                    break;
                case "5":
                    System.out.println("도움말입니다.");
                    break;
                case "0":
                    System.out.println("종료합니다.");
                    return;
                case "menu":
                    menuService.showMenu(MAIN_MENUS);
                    break;
                default:
                    System.out.println("올바른 메뉴번호를 입력하세요");
                    break;
            }
        }
    }
}
