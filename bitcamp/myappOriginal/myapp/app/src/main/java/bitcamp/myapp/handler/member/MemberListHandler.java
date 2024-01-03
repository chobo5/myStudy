package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

import java.util.Iterator;
import java.util.List;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class MemberListHandler extends AbstractMenuHandler {

    private List<Member> objectRepository;

    public MemberListHandler(Prompt prompt, List<Member> objectRepository) {
        super(prompt);
        this.objectRepository = objectRepository;
    }
    @Override
    public void action() {
        System.out.printf("%-10s\t%30s\t%s\n", "이름", "이메일", "가입일");

        Iterator<Member> iterator = objectRepository.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            System.out.printf("%-10s\t%30s\t%3$tY-%3$tm-%3$td\n", member.getName(), member.getEmail(), member.getCreatedDate());
        }

    }
}
