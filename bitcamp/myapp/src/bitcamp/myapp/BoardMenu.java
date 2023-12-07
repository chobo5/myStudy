package bitcamp.myapp;

import java.util.Arrays;
import java.util.Date;

public class BoardMenu {

    private Board[] boards = new Board[3];
    private int currentIndex = 0;
    private int newLength = 3;

    private String title;

    private Prompt prompt;

    public BoardMenu(String title, Prompt prompt) {
        this.title = title;
        this.prompt = prompt;
    }

    public void execute() {
        while (true) {
            final String[] ONBOARD_MENU = {this.title, "1.등록", "2.조회", "3.변경", "4.삭제","5.목록", "0.이전"};
            MenuProvider.showMenu(ONBOARD_MENU);
            String input = prompt.getUserInput("메인/" + this.title, "");
            switch (input) {
                case "1":
                    this.add();
                    break;
                case "2":
                    this.find();
                    break;
                case "3":
                    this.modify();
                    break;
                case "4":
                    this.delete();
                    break;
                case "5":
                    this.list();
                    break;
                case "0":
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return;
                case "menu":
                    MenuProvider.showMenu(ONBOARD_MENU);
                    break;
                default:
                    System.out.println("올바른 메뉴번호를 입력하세요");
                    break;
            }
        }
    }

    private void add() {
        System.out.printf("=> %s\n 등록", this.title);
        Board board = new Board();
        board.title = prompt.getUserInput("메인/" + this.title, "제목: ");
        board.content = prompt.getUserInput("메인/" + this.title, "내용: ");
        board.date = new Date();
        boards[currentIndex] = board;
        currentIndex += 1;
        if (currentIndex >= newLength) {
            newLength += 3;
        }
        Board[] newArray = Arrays.copyOf(boards, newLength);
        boards = newArray;

        System.out.println(this.title + " 등록이 완료되었습니다.");

    }

    private void find() {
        System.out.println(this.title + " 조회입니다.");
        int index = prompt.inputInt("메인/"+ this.title, "조회할 "+ this.title + "의 번호를 입력하세요.");
        System.out.println();
        if (index >= 0 && index < currentIndex) {
            System.out.printf("제목: %s\n", boards[index].title);
            System.out.printf("내용: %s\n", boards[index].content);
            System.out.printf("작성일: %s\n", boards[index].date);
        } else {
            System.out.println("존재하지 않는 게시물입니다.");
        }

    }

    private void modify() {
        System.out.println(this.title + " 변경입니다.");
        int index = prompt.inputInt("메인/" + this.title, "변경할 " + this.title + "번호를 입력하세요.");
        boards[index].title = prompt.getUserInput("메인/" + this.title, "제목 수정: ");
        boards[index].content = prompt.getUserInput("메인/" + this.title, "내용 수정: ");
        boards[index].date = new Date();
        System.out.println(this.title + " 변경이 완료되었습니다..");
    }

    private void delete() {
        System.out.println(this.title + " 삭제입니다.");
        int index = prompt.inputInt("메인/" + this.title, "삭제할 " + this.title + "번호를 입력하세요.");
        if (index >= 0 && index < currentIndex) {
            for (int i = index; i < currentIndex - 1; i++) {
                boards[i] = boards[i + 1];
            }
            boards[currentIndex] = null;
            currentIndex -= 1;
            System.out.println(this.title + " 삭제가 완료되었습니다.");
        } else {
            System.out.println("존재하지 않는" + this.title + "입니다.");
        }
    }

    private void list() {
        System.out.println(this.title + " 목록입니다.");
        System.out.printf("%-20s\t%s\n", this.title + " 제목", this.title + " 내용");
        for (int i = 0; i < currentIndex; i++) {
            System.out.printf("%-20s\t%s\n", boards[i].title, boards[i].content);
            System.out.println();
        }
    }


}