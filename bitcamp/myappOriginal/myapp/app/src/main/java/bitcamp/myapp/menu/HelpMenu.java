package bitcamp.myapp.menu;

import bitcamp.menu.Menu;
import bitcamp.util.Prompt;

public class HelpMenu implements Menu {
    Prompt prompt;
    String title;

    public HelpMenu(Prompt prompt, String title) {
        this.prompt = prompt;
        this.title = title;
    }

    public void execute(Prompt prompt) {
        System.out.println("도움말 입니다.");
    }

    @Override
    public String getTitle() {
        return title;
    }
}
