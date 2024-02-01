package app.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuItemList;

    private Menu() {
        this.menuItemList = new ArrayList<>();
    }

    public Menu getInstance() {
        return this;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItemList.add(menuItem);
    }

}
