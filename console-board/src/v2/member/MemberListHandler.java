package v2.member;

import v2.menu.MenuHandler;

import java.io.BufferedReader;
import java.util.List;

public class MemberListHandler implements MenuHandler {

    private BufferedReader in;
    private MemberRepository memberRepository;


    public MemberListHandler(BufferedReader in, MemberRepository memberRepository) {
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
