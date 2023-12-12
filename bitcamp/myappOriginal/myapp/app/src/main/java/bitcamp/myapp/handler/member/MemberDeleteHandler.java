package bitcamp.myapp.handler.member;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class MemberDeleteHandler implements MenuHandler {
    MemberRepository memberRepository;
    Prompt prompt;

    public MemberDeleteHandler(Prompt prompt, MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        this.prompt = prompt;
    }
    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = this.prompt.inputInt("번호? ");

        if (this.memberRepository.remove(index) == null) {
            System.out.println("회원 번호가 유효하지 않습니다.");
            return;
        }

        System.out.println("성공적으로 삭제되었습니다.");
    }
}
