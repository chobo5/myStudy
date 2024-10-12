package v2.member;

import v2.menu.MenuHandler;

import java.io.BufferedReader;

public class MemberModifyHandler implements MenuHandler {

    private BufferedReader in;
    private MemberRepository memberRepository;


    public MemberModifyHandler(BufferedReader in, MemberRepository memberRepository) {
        this.in = in;
        this.memberRepository = memberRepository;
    }


    @Override
    public void action() {
        try {
            System.out.println("수정할 회원 번호를 입력하세요");
            int memberNo = Integer.parseInt(in.readLine());
            Member member = memberRepository.findByNo(memberNo);

            System.out.println("이름: ");
            String name = in.readLine();
            member.setName(name);

            System.out.println("이메일: ");
            String email = in.readLine();
            member.setEmail(email);

            System.out.println("비밀번호: ");
            String password = in.readLine();
            member.setPassword(password);

            System.out.println("회원정보 수정이 완료되었습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
