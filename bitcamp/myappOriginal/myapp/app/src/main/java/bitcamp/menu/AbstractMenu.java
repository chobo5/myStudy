package bitcamp.menu;

import java.util.Stack;

public abstract class AbstractMenu implements Menu{
    protected Stack<String> breadCrumb;
    protected String title;
    public AbstractMenu(String title, Stack<String> breadCrumb) {
        this.title = title;
        this.breadCrumb = breadCrumb;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    public String getMenuPath() {
        return String.join("/", breadCrumb.toArray(new String[0]));
    }
}
