package bitcamp.myapp.handler.help;

import bitcamp.menu.AbstractMenu;
import bitcamp.util.Prompt;

public class HelpMenu extends AbstractMenu {
    Prompt prompt;

    public HelpMenu(String title) {
        super(title);
    }

    public void execute(Prompt prompt) {
        System.out.println("도움말 입니다.");
    }


    public String getTitle() {
        return this.getTitle();
    }
}
