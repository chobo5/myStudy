package bitcamp.myapp;

import bitcamp.util.Prompt;

public class MenuItem implements Menu {
    private String title;

    public MenuItem(String title, Prompt prompt) {
        this.title = title;
    }

    @Override
    public void execute(Prompt prompt) {
        System.out.println(this.title + " 입니다.");
    }

    @Override
    public String getTitle() {
        return this.title;
    }
}
