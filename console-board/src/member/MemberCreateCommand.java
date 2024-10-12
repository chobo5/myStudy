package member;

import menu.MenuCommand;

import java.io.BufferedReader;

public class MemberCreateCommand implements MenuCommand {

    private BufferedReader in;
    private MemberRepository memberRepository;


    public MemberCreateCommand(BufferedReader in, MemberRepository memberRepository) {
        this.in = in;
        this.memberRepository = memberRepository;
    }


    @Override
    public void action() {
        try {
            System.out.println("이름: ");
            String name = in.readLine();
            System.out.println("이메일: ");
            String email = in.readLine();
            System.out.println("비밀번호: ");
            String password = in.readLine();
            Member member = new Member(name, email, password);
            memberRepository.save(member);
            System.out.println("회원가입이 완료되었습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
