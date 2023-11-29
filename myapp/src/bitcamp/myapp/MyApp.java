package bitcamp.myapp;

import java.util.Scanner;

public class MyApp {
    private static final String RESET = "\u001B[0m";
    private static final String FONT_RED_BOLD = "\033[1;31m";
    private static final String title = "[과제관리 시스템]";
    private static final String menu1 = "1.과제";
    private static final String menu2 = "2.게시글";
    private static final String menu3 = "3.도움말";
    private static final String menu4 = "4.종료";
    public static void main(String[] args) {
        System.out.println(FONT_RED_BOLD + title + RESET);
        System.out.println();
        System.out.println(menu1);
        System.out.println(menu2);
        System.out.println(menu3);
        System.out.println(menu4);

        Scanner sc = new Scanner(System.in);
        int menuId = sc.nextInt();
        switch (menuId) {
            case 1:
                System.out.println("과제입니다.");
                break;
            case 2:
                System.out.println("게시글입니다.");
                break;
            case 3:
                System.out.println("도움말입니다.");
                break;
            case 4:
                System.out.println("종료합니다.");
                break;
        }

    }
}