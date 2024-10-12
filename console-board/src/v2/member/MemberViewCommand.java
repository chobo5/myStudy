package v2.member;

import v2.menu.MenuCommand;

import java.io.BufferedReader;

public class MemberViewCommand implements MenuCommand {

    private BufferedReader in;
    private MemberRepository memberRepository;


    public MemberViewCommand(BufferedReader in, MemberRepository memberRepository) {
        this.in = in;
        this.memberRepository = memberRepository;
    }


    @Override
    public void action() {
        try {
            System.out.println("열람할 회원 번호를 입력하세요");
            int memberNo = Integer.parseInt(in.readLine());
            Member member = memberRepository.findByNo(memberNo);
            System.out.println(member.allToString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
