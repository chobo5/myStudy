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
public class MemberListHandler extends AbstractMenuHandler {

    private ArrayList<Member> objectRepository;

    public MemberListHandler(Prompt prompt, ArrayList<Member> objectRepository) {
        super(prompt);
        this.objectRepository = objectRepository;
    }
    @Override
    public void action() {
        System.out.printf("%-10s\t%30s\t%s\n", "이름", "이메일", "가입일");
        Object[] objects = this.objectRepository.toArray();
        if (objects == null) {
            System.out.println("회원이 존재하지 않습니다.");
            return;
        }
        for (Object object : objects) {
            Member member = (Member) object;
            System.out.printf("%-10s\t%30s\t%s\n", member.getName(), member.getEmail(), member.getCreatedDate());
        }
    }
}
