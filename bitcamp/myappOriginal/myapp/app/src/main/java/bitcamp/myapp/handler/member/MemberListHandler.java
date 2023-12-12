package bitcamp.myapp.handler.member;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class MemberListHandler implements MenuHandler {

    MemberRepository memberRepository;

    public MemberListHandler(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
        System.out.printf("%-10s\t%30s\t%s\n", "이름", "이메일", "가입일");
        Member[] members = this.memberRepository.toArray();
        if (members == null) {
            System.out.println("회원이 존재하지 않습니다.");
            return;
        }
        for (Member member : members) {
            System.out.printf("%-10s\t%30s\t%s\n", member.name, member.email, member.createdDate);
        }
    }
}
