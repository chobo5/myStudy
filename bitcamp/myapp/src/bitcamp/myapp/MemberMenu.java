package bitcamp.myapp;

import java.util.Arrays;
import java.util.Date;

public class MemberMenu {

    private Member[] members = new Member[3];
    private int currentIndex = 0;
    private int newLength = 3;
    private String title;

    private Prompt prompt;
    public MemberMenu(String title, Prompt prompt) {
        this.title = title;
        this.prompt = prompt;
    }


    public void execute() {
        while (true) {
            final String[] MEMBER_MENU = {this.title, "1.등록", "2.조회", "3.변경", "4.삭제","5.목록", "0.이전"};
            MenuProvider.showMenu(MEMBER_MENU);
            String input = prompt.getUserInput("메인/회원관리", "");
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
                    MenuProvider.showMenu(MEMBER_MENU);
                    break;
                default:
                    System.out.println("올바른 메뉴번호를 입력하세요");
                    break;
            }
        }
    }

    private void add() {
        System.out.println("=> 호원 등록");
        Member member = new Member();
        member.name = prompt.getUserInput("메인/회원관리", "이름: ");
        member.email = prompt.getUserInput("메인/회원관리", "이메일: ");
        member.date = new Date();
        members[currentIndex] = member;
        currentIndex += 1;
        if (currentIndex >= newLength) {
            newLength += 3;
        }
        Member[] newArray = Arrays.copyOf(members, newLength);
        members = newArray;

        System.out.println("회원 등록이 완료되었습니다.");

    }

    private void find() {
        System.out.println("회원 조회입니다.");
        int index = prompt.inputInt("메인/회원관리", "조회할 회원의 번호를 입력하세요.");
        System.out.println();
        if (index >= 0 && index < currentIndex) {
            System.out.printf("이름: %s\n", members[index].name);
            System.out.printf("이메일: %s\n", members[index].email);
            System.out.printf("가입일: %s\n", members[index].date);
        } else {
            System.out.println("존재하지 않는 회원입니다.");
        }

    }

    private void modify() {
        System.out.println("회원정보 변경입니다.");
        int index = prompt.inputInt("메인/회원관리", "변경할 회원 번호를 입력하세요.");
        members[index].name = prompt.getUserInput("메인/회원관리", "회원 수정: ");
        members[index].email = prompt.getUserInput("메인/회원관리", "회원 수정: ");
        members[index].date = new Date();
        System.out.println("회원정보 변경이 완료되었습니다..");
    }

    private void delete() {
        System.out.println("회원정보 삭제입니다.");
        int index = prompt.inputInt("메인/회원관리", "삭제할 회원의 번호를 입력하세요.");
        if (index >= 0 && index < currentIndex) {
            for (int i = index; i < currentIndex - 1; i++) {
                members[i] = members[i + 1];
            }
            members[currentIndex] = null;
            currentIndex -= 1;
            System.out.println("회원정보 삭제가 완료되었습니다.");
        } else {
            System.out.println("존재하지 않는 회원정보 입니다.");
        }
    }

    private void list() {
        System.out.println("회원정보 목록입니다.");
        System.out.printf("%-20s\t%s\n", "회원 이름", "회원 이메일");
        for (int i = 0; i < currentIndex; i++) {
            System.out.printf("%-20s\t%s\n", members[i].name, members[i].email);
            System.out.println();
        }
    }
}
