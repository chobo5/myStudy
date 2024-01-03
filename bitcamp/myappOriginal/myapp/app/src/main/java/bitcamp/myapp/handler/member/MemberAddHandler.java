package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

import java.util.Date;
import java.util.List;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class MemberAddHandler extends AbstractMenuHandler {
    private List<Member> objectRepository;

    public MemberAddHandler(Prompt prompt, List<Member> objectRepository) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    public void action() {

        Member member = new Member();
        member.setName(this.prompt.input("이름? "));
        member.setEmail(this.prompt.input("이메일? "));
        member.setPassword(this.prompt.input("암호? "));
        member.setCreatedDate(new Date());

        this.objectRepository.add(member);

    }
}
