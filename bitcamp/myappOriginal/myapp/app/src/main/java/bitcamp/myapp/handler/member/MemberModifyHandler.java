package bitcamp.myapp.handler.member;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class MemberModifyHandler implements MenuHandler {
    MemberRepository memberRepository;
    Prompt prompt;

    public MemberModifyHandler(Prompt prompt, MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        this.prompt = prompt;
    }
    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = this.prompt.inputInt("번호? ");
        Member oldMember = this.memberRepository.get(index);
        if (oldMember == null) {
            System.out.println("회원 번호가 유효하지 않습니다.");
            return;
        }

        Member newMember = new Member();
        newMember.email = this.prompt.input("이메일(%s)? ", oldMember.email);
        newMember.name = this.prompt.input("이름(%s)? ", oldMember.name);
        newMember.password = this.prompt.input("새 암호? ");
        newMember.createdDate = this.prompt.input("가입일(%s)? ", oldMember.createdDate);
        this.memberRepository.set(index, newMember);
    }
}
