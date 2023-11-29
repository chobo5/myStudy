package bitcamp.myapp;

import java.util.Scanner;

public class MyApp {
    private static final String RESET = "\u001B[0m";
    private static final String FONT_RED_BOLD = "\033[1;31m";
    private static final String[] MENUS = {"[과제관리 시스템]", "1.과제", "2.게시글", "3.도움말", "4.종료"};
    private static final Scanner sc = new Scanner(System.in);

    private static void showMenu() {
        System.out.println(FONT_RED_BOLD + MENUS[0] + RESET);
        System.out.println();
        for (int i = 1; i < MENUS.length ; i++) {
            System.out.println(MENUS[i]);
        }
    }

    private static String getUserInput() {
        System.out.print("> ");
        return MyApp.sc.nextLine();
    }

    public static void main(String[] args) {

        showMenu();
        boolean run = true;
        while (run) {
            String input = getUserInput();
            switch (input) {
                case "1":
                    System.out.println("과제입니다.");
                    break;
                case "2":
                    System.out.println("게시글입니다.");
                    break;
                case "3":
                    System.out.println("도움말입니다.");
                    break;
                case "4":
                    System.out.println("종료합니다.");
                    run = false;
                    break;
                case "menu":
                    showMenu();
                    break;
                default:
                    System.out.println("올바른 메뉴번호를 입력하세요");
                    break;
            }
        }
    }
}