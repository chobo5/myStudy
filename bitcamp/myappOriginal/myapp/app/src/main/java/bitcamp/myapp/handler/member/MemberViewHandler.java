package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class MemberViewHandler extends AbstractMenuHandler {

    private ArrayList<Member> objectRepository;

    public MemberViewHandler(Prompt prompt, ArrayList<Member> objectRepository) {
        super(prompt);
        this.objectRepository = objectRepository;
    }
    @Override
    public void action() {

        int index = this.prompt.inputInt("번호? ");
        Member member = this.objectRepository.get(index);
        if (member == null) {
            System.out.println("회원 번호가 유효하지 않습니다.");
            return;
        }

        System.out.printf("이메일: %s\n", member.getEmail());
        System.out.printf("이름: %s\n", member.getName());
        System.out.printf("가입일: %s\n", member.getCreatedDate());
    }
}
