package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BasicDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

import java.util.Date;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class MemberModifyHandler extends AbstractMenuHandler {
    private BasicDao memberDao;

    public MemberModifyHandler(Prompt prompt, BasicDao memberDao) {
        super(prompt);
        this.memberDao = memberDao;
    }
    @Override
    public void action() {

        int index = this.prompt.inputInt("번호? ");
        Member oldMember = (Member) this.memberDao.findBy(index);
        if (oldMember == null) {
            System.out.println("회원 번호가 유효하지 않습니다.");
            return;
        }

        Member newMember = new Member();
        newMember.setNo(oldMember.getNo());
        newMember.setEmail(this.prompt.input("이메일(%s)? ", oldMember.getEmail()));
        newMember.setName(this.prompt.input("이름(%s)? ", oldMember.getName()));
        newMember.setPassword(this.prompt.input("새 암호? "));
        newMember.setCreatedDate(new Date());
        this.memberDao.update(newMember);
    }
}
