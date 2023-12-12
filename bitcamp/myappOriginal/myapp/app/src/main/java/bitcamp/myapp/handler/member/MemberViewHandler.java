package bitcamp.myapp.handler.member;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class MemberViewHandler implements MenuHandler {

    MemberRepository memberRepository;
    Prompt prompt;

    public MemberViewHandler(Prompt prompt, MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        this.prompt = prompt;
    }
    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = this.prompt.inputInt("번호? ");
        Member member = this.memberRepository.get(index);
        if (member == null) {
            System.out.println("회원 번호가 유효하지 않습니다.");
            return;
        }

        System.out.printf("이메일: %s\n", member.email);
        System.out.printf("이름: %s\n", member.name);
        System.out.printf("가입일: %s\n", member.createdDate);
    }
}
