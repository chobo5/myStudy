package bitcamp.myapp.menu;

import bitcamp.util.Prompt;

public class HelpMenu {
    Prompt prompt;
    String title;

    public HelpMenu(Prompt prompt, String title) {
        this.prompt = prompt;
        this.title = title;
    }

    public void execute() {
        System.out.println("도움말 입니다.");
    }
}
