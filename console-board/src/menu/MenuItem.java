package menu;

import java.io.BufferedReader;

public class MenuItem implements Menu {
    private String name;
    private MenuCommand menuCommand;

    public MenuItem(String name, MenuCommand menuCommand) {
        this.name = name;
        this.menuCommand = menuCommand;
    }

    @Override
    public void execute(BufferedReader in) {
        menuCommand.action();
    }

    @Override
    public String getName() {
        return name;
    }
}
