package bitcamp.myapp.menu;

import bitcamp.menu.MenuHandler;
import bitcamp.util.Prompt;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class BoardModifyHandler implements MenuHandler {
    @Override
    public void action(Prompt prompt) {
        System.out.println("게시글을 수정합니다.");
    }
}