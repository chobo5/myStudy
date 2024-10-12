package menu;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class MenuGroup implements Menu {
    private String name;
    private List<Menu> menus = new ArrayList<>();

    public MenuGroup(String name) {
        this.name = name;
    }

    @Override
    public void execute(BufferedReader in) {
        printMenu();
        try {
            int menuNo = Integer.parseInt(in.readLine()) - 1;
            if (menuNo < 0 || menuNo > menus.size() - 1) {
                System.out.println("메뉴 번호가 옳지 않습니다.");
            }

            menus.get(menuNo).execute(in);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getName() {
        return name;
    }

    private void printMenu() {
        for (int i = 0; i < menus.size(); i++) {
            System.out.println(i + 1 + ". " + menus.get(i).getName());
        }
    }

    public void add(Menu menu) {
        menus.add(menu);
    }

}
