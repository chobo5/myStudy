package v2.member;

import v2.menu.MenuCommand;

import java.io.BufferedReader;
import java.util.List;

public class MemberListCommand implements MenuCommand {

    private BufferedReader in;
    private MemberRepository memberRepository;


    public MemberListCommand(BufferedReader in, MemberRepository memberRepository) {
        this.in = in;
        this.memberRepository = memberRepository;
    }


    @Override
    public void action() {
        try {
            List<Member> memberList = memberRepository.list();
            memberList.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
