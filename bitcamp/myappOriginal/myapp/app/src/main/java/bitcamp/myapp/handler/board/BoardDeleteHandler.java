package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BasicDao;
import bitcamp.util.Prompt;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class BoardDeleteHandler extends AbstractMenuHandler {
    private BasicDao dao;

    public BoardDeleteHandler(Prompt prompt, BasicDao dao) {
        super(prompt);
        this.dao = dao;
    }
    @Override
    protected void action() {
        int no = this.prompt.inputInt("번호? ");
        int result = this.dao.delete(no);
        if (result == 0) {
            System.out.println("게시글 번호가 유효하지 않습니다.");
        } else {
            System.out.println("삭제되었습니다.");
        }
    }
}
