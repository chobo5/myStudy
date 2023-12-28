package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.List;
import bitcamp.util.Prompt;

import java.util.ArrayList;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class BoardDeleteHandler extends AbstractMenuHandler {
    private List<Board> objectRepository;

    public BoardDeleteHandler(Prompt prompt, List<Board> objectRepository) {
        super(prompt);
        this.objectRepository = objectRepository;
    }
    @Override
    protected void action() {
        int index = this.prompt.inputInt("번호? ");
        this.objectRepository.remove(index);
    }
}
