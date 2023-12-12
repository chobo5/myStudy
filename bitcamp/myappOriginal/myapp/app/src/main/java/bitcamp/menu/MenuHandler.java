package bitcamp.menu;

import bitcamp.util.Prompt;

public interface MenuHandler {
    //사용자가 메뉴를 선택하면
    //menuItem 객체를 다음규칙에 따라 메서드를 호출한다.
    public abstract void action(Menu menu);
}
