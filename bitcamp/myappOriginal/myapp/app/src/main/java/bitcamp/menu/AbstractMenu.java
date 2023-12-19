package bitcamp.menu;

import bitcamp.util.Prompt;

public abstract class AbstractMenu implements Menu{
    private String title;
    public AbstractMenu(String title) {
        this.title = title;
    }


    @Override
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
