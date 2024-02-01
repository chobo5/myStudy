package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("[도서 관리 시스템]");
        Scanner sc = new Scanner(System.in);
        loop:
        while(true) {
            System.out.println("1.도서 등록");
            System.out.println("2.도서 검색");
            System.out.println("3.도서 수정");
            System.out.println("4.도서 삭제");
            System.out.println("0.종료");
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    System.out.println("검색어를 입력해주세요.");
                    input = sc.nextLine();
                case "2":
                    System.out.println("검색어를 입력해주세요.");
                    input = sc.nextLine();
                case "3":
                    System.out.println("검색어를 입력해주세요.");
                    input = sc.nextLine();
                case "4":
                    System.out.println("검색어를 입력해주세요.");
                    input = sc.nextLine();
                case "0":
                    System.out.println("프로그램을 종료합니다.");
                    input = sc.nextLine();
                    break loop;
                default:
                    System.out.println("등록되지 않은 메뉴입니다.");
            }
        }
        sc.close();
    }
}