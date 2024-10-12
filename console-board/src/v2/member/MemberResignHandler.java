package v2.member;

import v2.menu.MenuHandler;

import java.io.BufferedReader;

public class MemberResignHandler implements MenuHandler {

    private BufferedReader in;
    private MemberRepository memberRepository;

    public MemberResignHandler(BufferedReader in, MemberRepository memberRepository) {
        this.in = in;
        this.memberRepository = memberRepository;
    }


    @Override
    public void action() {
        try {
            System.out.println("탈퇴할 회원 번호를 입력하세요");
            int memberNo = Integer.parseInt(in.readLine());

            memberRepository.delete(memberNo);
            System.out.println("회원 탈퇴가 완료되었습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
