package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BasicDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

import java.util.List;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class BoardListHandler extends AbstractMenuHandler {

    private BasicDao dao;

    public BoardListHandler(Prompt prompt, BasicDao dao) {
        super(prompt);
        this.dao = dao;
    }

    @Override
    protected void action() {
        System.out.printf("%-4s\t%-20s\t%10s\t%s\n", "NO", "Title", "Writer", "Date");

        List<Board> list = dao.findAll();
        for (Board board : list) {
            System.out.printf("%-4d\t%-20s\t%10s\t%4$tY-%4$tm-%4$td\n", board.getNo(), board.getTitle(), board.getWriter(),
                    board.getCreatedDate());
        }

    }
}
