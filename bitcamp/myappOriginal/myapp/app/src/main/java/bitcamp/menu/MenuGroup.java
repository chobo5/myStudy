package bitcamp.menu;

import bitcamp.util.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MenuGroup extends AbstractMenu {
    private List<Menu> menus = new LinkedList<>();

    private MenuGroup(String title, Stack<String> breadCrumb) {
        super(title, breadCrumb);
    }

    public static MenuGroup getInstance(String title) {
        return new MenuGroup(title, new Stack<String>());
    }

    @Override
    public void execute(Prompt prompt) {
        breadCrumb.push(title);
        this.printMenu();

        while (true) {
            String input = prompt.input("%s> ", this.getMenuPath());

            if (input.equals("menu")) {
                this.printMenu();
                continue;
            } else if (input.equals("0")) {
                break;
            }

            try {
                int menuNumber = Integer.parseInt(input);
                menus.get(menuNumber - 1).execute(prompt);
            } catch (Exception e) {
                System.out.println("메뉴 번호가 옳지 않습니다.");
            }
        }
        breadCrumb.pop();
    }

    public void add(Menu menu) {
       menus.add(menu);
    }

    public MenuItem addItem(String title, MenuHandler handler) {
        MenuItem menuItem = new MenuItem(title, handler, this.breadCrumb);
        this.add(menuItem);
        return menuItem;
    }

    public MenuGroup addGroup(String title) {
        MenuGroup menuGroup = new MenuGroup(title, this.breadCrumb);
        this.add(menuGroup);
        return menuGroup;
    }
    public void remove(Menu menu) {
        this.menus.remove(menu);
    }

    private void printMenu() {
        System.out.printf(AnsiEscape.ANSI_BOLD_RED +"[%s]\n" + AnsiEscape.ANSI_CLEAR, this.getTitle());

        Iterator<Menu> iterator = menus.iterator();
        int i = 1;
        while(iterator.hasNext()) {
            System.out.printf("%d. %s\n", i++, iterator.next().getTitle());
        }

        System.out.printf("0. %s\n", "이전");
    }
}
