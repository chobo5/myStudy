package org.example.menu;
import org.example.util.Prompt;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuItemList;

    private Menu() {
        this.menuItemList = new ArrayList<>();
    }

    public static Menu getInstance() {
        return new Menu();
    }

    public void addMenuItem(MenuItem...menuItems) {
        for (MenuItem item : menuItems) {
            menuItemList.add(item);
        }
    }

    public void execute(Prompt prompt) {
        while (true) {
            try {
                for (int i = 0; i < menuItemList.size(); i++) {
                    System.out.println((i + 1) + ". " + menuItemList.get(i).getTitle());
                }
                int input = prompt.inputInt("메뉴 번호 입력: ") - 1;
                menuItemList.get(input).execute();
            } catch (Exception e) {
                System.out.println("잘못된 입력");
            }

        }
    }

}
