package menu;

import java.io.BufferedReader;

public class MenuItem implements Menu {
    private String name;
    private MenuHandler menuHandler;

    public MenuItem(String name, MenuHandler menuHandler) {
        this.name = name;
        this.menuHandler = menuHandler;
    }

    @Override
    public void execute(BufferedReader in) {
        menuHandler.action();
    }

    @Override
    public String getName() {
        return name;
    }
}
