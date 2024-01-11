package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BasicDao;
import bitcamp.util.Prompt;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class MemberDeleteHandler extends AbstractMenuHandler {
    private BasicDao memberDao;

    public MemberDeleteHandler(Prompt prompt, BasicDao memberDao) {
        super(prompt);
        this.memberDao = memberDao;
    }
    @Override
    public void action() {
        int index = this.prompt.inputInt("번호? ");
        this.memberDao.delete(index);
    }
}
