package bitcamp.myapp;

import java.util.Arrays;
import java.util.Date;

public class GreetingBoardMenu {
    private static final String[] ONBOARD_MENU = {"가입인사", "1.등록", "2.조회", "3.변경", "4.삭제","5.목록", "0.이전"};
    static Board[] boards = new Board[3];
    static int currentIndex = 0;
    static int newLength = 3;

    public static void execute() {
        while (true) {
            MenuProvider.showMenu(ONBOARD_MENU);
            String input = Prompt.getUserInput("메인/게시글", "");
            switch (input) {
                case "1":
                    add();
                    break;
                case "2":
                    find();
                    break;
                case "3":
                    modify();
                    break;
                case "4":
                    delete();
                    break;
                case "5":
                    list();
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

    private static void add() {
        System.out.println("=> 가입인사 등록");
        Board board = new Board();
        board.title = Prompt.getUserInput("메인/가입인사", "제목: ");
        board.content = Prompt.getUserInput("메인/가입인사", "내용: ");
        board.date = new Date();
        boards[currentIndex] = board;
        currentIndex += 1;
        if (currentIndex >= newLength) {
            newLength += 3;
        }
        Board[] newArray = Arrays.copyOf(boards, newLength);
        boards = newArray;

        System.out.println("가입인사 등록이 완료되었습니다.");

    }

    private static void find() {
        System.out.println("가입인사 조회입니다.");
        String strIndex = Prompt.getUserInput("메인/가입인사", "조회할 가입인사 번호를 입력하세요.");
        int index = Integer.parseInt(strIndex);
        System.out.println();
        if (index >= 0 && index < currentIndex) {
            System.out.printf("가입인사 제목: %s\n", boards[index].title);
            System.out.printf("내용: %s\n", boards[index].content);
            System.out.printf("작성일: %s\n", boards[index].date);
        } else {
            System.out.println("존재하지 않는 게시물입니다.");
        }

    }

    private static void modify() {
        System.out.println("가입인사 변경입니다.");
        String strIndex = Prompt.getUserInput("메인/가입인사", "변경할 가입인사 번호를 입력하세요.");
        int index = Integer.parseInt((strIndex));
        boards[index].title = Prompt.getUserInput("메인/가입인사", "제목 수정: ");
        boards[index].content = Prompt.getUserInput("메인/가입인사", "내용 수정: ");
        boards[index].date = new Date();
        System.out.println("가입인사 변경이 완료되었습니다..");
    }

    private static void delete() {
        System.out.println("가입인사 삭제입니다.");
        String strIndex = Prompt.getUserInput("메인/가입인사", "삭제할 가입인사 번호를 입력하세요.");
        int index = Integer.parseInt(strIndex);
        if (index >= 0 && index < currentIndex) {
            for (int i = index; i < currentIndex - 1; i++) {
                boards[i] = boards[i + 1];
            }
            boards[currentIndex] = null;
            currentIndex -= 1;
            System.out.println("가입인사 삭제가 완료되었습니다.");
        } else {
            System.out.println("존재하지 않는 가입인사 입니다.");
        }
    }

    private static void list() {
        System.out.println("가입인사 목록입니다.");
        System.out.printf("%-20s\t%s\n", "가입인사 제목", "가입인사 내용");
        for (int i = 0; i < currentIndex; i++) {
            System.out.printf("%-20s\t%s\n", boards[i].title, boards[i].content);
            System.out.println();
        }
    }


}