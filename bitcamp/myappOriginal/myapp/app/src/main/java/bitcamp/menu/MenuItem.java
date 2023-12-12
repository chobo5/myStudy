package bitcamp.menu;

import bitcamp.util.Prompt;

//Composite 패턴에서 leaf역할을 수행하는 클래스
//Leaf
// - 하위 항목을 포함하지 않는 말단 객체.
public class MenuItem implements Menu {
    String title;
    MenuHandler menuHandler;

    public MenuItem(String title) {
        this.title = title;
    }

    public MenuItem(String title, MenuHandler menuHandler) {
        this(title);
        this.menuHandler = menuHandler;
    }

    @Override
    public void execute(Prompt prompt) {
        if(this.menuHandler != null) {
            this.menuHandler.action(this);
        }
    }

    @Override
    public String getTitle() {
        return this.title;
    }
}
