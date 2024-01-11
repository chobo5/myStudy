package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BasicDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

import java.util.List;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class MemberListHandler extends AbstractMenuHandler {

    private BasicDao memberDao;

    public MemberListHandler(Prompt prompt, BasicDao memberDao) {
        super(prompt);
        this.memberDao = memberDao;
    }
    @Override
    public void action() {
        System.out.printf("%-4s\t%-10s\t%30s\t%s\n", "NO", "이름", "이메일", "가입일");

        List<Member> list = memberDao.findAll();
        for (Member member : list) {
            System.out.printf("%-4d\t%-10s\t%30s\t%4$tY-%4$tm-%4$td\n", member.getNo(), member.getName(), member.getEmail(), member.getCreatedDate());
        }

    }
}
