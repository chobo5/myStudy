package bitcamp.myapp.handler.member;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class MemberAddHandler implements MenuHandler {

    Prompt prompt;
    MemberRepository memberRepository;

    public MemberAddHandler(Prompt prompt, MemberRepository memberRepository) {
        this.prompt = prompt;
        this.memberRepository = memberRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        Member member = new Member();
        member.email = this.prompt.input("이메일? ");
        member.name = this.prompt.input("이름? ");
        member.password = this.prompt.input("암호? ");
        member.createdDate = this.prompt.input("가입일? ");

        this.memberRepository.add(member);

    }
}
