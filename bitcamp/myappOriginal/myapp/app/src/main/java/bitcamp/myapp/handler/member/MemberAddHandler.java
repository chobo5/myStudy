package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;
import java.util.Date;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class MemberAddHandler extends AbstractMenuHandler {
    private ArrayList<Member> objectRepository;

    public MemberAddHandler(Prompt prompt, ArrayList<Member> objectRepository) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    public void action() {

        Member member = new Member();
        member.setEmail(this.prompt.input("이메일? "));
        member.setName(this.prompt.input("이름? "));
        member.setPassword(this.prompt.input("암호? "));
        member.setCreatedDate(new Date());

        this.objectRepository.add(member);

    }
}
