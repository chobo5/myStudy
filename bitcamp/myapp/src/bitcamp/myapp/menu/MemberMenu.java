package bitcamp.myapp.menu;

import bitcamp.myapp.menu.MenuService;
import bitcamp.util.Prompt;
import bitcamp.myapp.vo.Member;
import java.util.Date;

public class MemberMenu {

    private String title;
    private Prompt prompt;

    private MenuService<Member> menuService;
    public MemberMenu(String title, Prompt prompt) {
        this.title = title;
        this.prompt = prompt;
        menuService = new MenuService<Member>(3);
    }


    public void execute() {
        while (true) {
            final String[] MEMBER_MENU = {this.title, "1.등록", "2.조회", "3.변경", "4.삭제","5.목록", "0.이전"};
            menuService.showMenu(MEMBER_MENU);
            String input = prompt.getUserInput("메인/회원관리", "");
            switch (input) {
                case "1":
                    addMember();
                    break;
                case "2":
                    getMember();
                    break;
                case "3":
                    modifyMember();
                    break;
                case "4":
                    deleteMember();
                    break;
                case "5":
                    getAllMembers();
                    break;
                case "0":
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return;
                case "menu":
                    menuService.showMenu(MEMBER_MENU);
                    break;
                default:
                    System.out.println("올바른 메뉴번호를 입력하세요");
                    break;
            }
        }
    }

    private void addMember() {
        System.out.println("=> 호원 등록");
        Member member = new Member();
        member.name = prompt.getUserInput("메인/회원관리", "이름: ");
        member.email = prompt.getUserInput("메인/회원관리", "이메일: ");
        member.date = new Date();
        menuService.add(member);

    }

    private void getMember() {
        System.out.println("회원 조회입니다.");
        int index = prompt.inputInt("메인/회원관리", "조회할 회원의 번호를 입력하세요.");
        menuService.get(index);
    }

    private void modifyMember() {
        System.out.println("회원정보 변경입니다.");
        int index = prompt.inputInt("메인/회원관리", "변경할 회원 번호를 입력하세요.");
        Member member = new Member();
        member.name = prompt.getUserInput("메인/회원관리", "회원 수정: ");
        member.email = prompt.getUserInput("메인/회원관리", "회원 수정: ");
        member.date = new Date();
        menuService.modify(index, member);
    }

    private void deleteMember() {
        System.out.println("회원정보 삭제입니다.");
        int index = prompt.inputInt("메인/회원관리", "삭제할 회원의 번호를 입력하세요.");
        menuService.delete(index);
    }

    private void getAllMembers() {
        System.out.println("회원정보 목록입니다.");
        System.out.printf("%-20s\t%s\n", "회원 이름", "회원 이메일");
        menuService.getAll();
    }
}
