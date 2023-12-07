package bitcamp.myapp.menu.ui;

import bitcamp.myapp.menu.MenuService;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;
import bitcamp.myapp.vo.Board;
import java.util.Date;

public class BoardMenu {
    private final String title;

    private Prompt prompt;

    private MenuService<Board> menuService;

    public BoardMenu(String title, Prompt prompt) {
        this.title = title;
        this.prompt = prompt;
        menuService = new MenuService<Board>(3);
    }

    public void execute() {
        while (true) {
            final String[] ONBOARD_MENU = {this.title, "1.등록", "2.조회", "3.변경", "4.삭제","5.목록", "0.이전"};
            menuService.showMenu(ONBOARD_MENU);
            String input = prompt.getUserInput("메인/" + this.title, "");
            switch (input) {
                case "1":
                    this.addBoard();
                    break;
                case "2":
                    this.findBoard();
                    break;
                case "3":
                    this.modifyBoard();
                    break;
                case "4":
                    this.deleteBoard();
                    break;
                case "5":
                    this.getAllBoards();
                    break;
                case "0":
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return;
                case "menu":
                    menuService.showMenu(ONBOARD_MENU);
                    break;
                default:
                    System.out.println("올바른 메뉴번호를 입력하세요");
                    break;
            }
        }
    }

    private void addBoard() {
        System.out.printf("=> %s\n 등록", this.title);
        Board board = new Board();
        board.title = prompt.getUserInput("메인/" + this.title, "제목: ");
        board.content = prompt.getUserInput("메인/" + this.title, "내용: ");
        board.date = new Date();
        menuService.add(board);

    }

    private void findBoard() {
        System.out.println(this.title + " 조회입니다.");
        int index = prompt.inputInt("메인/"+ this.title, "조회할 "+ this.title + "의 번호를 입력하세요.");
        menuService.get(index);
    }

    private void modifyBoard() {
        System.out.println(this.title + " 변경입니다.");
        int index = prompt.inputInt("메인/" + this.title, "변경할 " + this.title + "번호를 입력하세요.");
        Board board = new Board();
        board.title = prompt.getUserInput("메인/" + this.title, "제목 수정: ");
        board.content = prompt.getUserInput("메인/" + this.title, "내용 수정: ");
        board.date = new Date();
        menuService.modify(index, board);
    }

    private void deleteBoard() {
        System.out.println(this.title + " 삭제입니다.");
        int index = prompt.inputInt("메인/" + this.title, "삭제할 " + this.title + "번호를 입력하세요.");
        menuService.delete(index);
    }

    private void getAllBoards() {
        System.out.println(this.title + " 목록입니다.");
        System.out.printf("%-20s\t%s\n", this.title + " 제목", this.title + " 내용");
        menuService.getAll();
    }


}