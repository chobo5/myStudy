package bitcamp.menu;

import bitcamp.util.AnsiEscape;
import bitcamp.util.LinkedList;
import bitcamp.util.Prompt;

public class MenuGroup extends AbstractMenu {
    private LinkedList<Menu> menus = new LinkedList<>();
    public MenuGroup(String title) {
        super(title);
    }

    @Override
    public void execute(Prompt prompt) {
        this.printMenu();

        while (true) {
            String input = prompt.input("%s> ", this.getTitle());

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

    }

    public void add(Menu menu) {
       menus.add(menu);
    }

    public void remove(Menu menu) {
        int index = indexOf(menu);
        menus.remove(index);
    }

    private int indexOf(Menu menu) {
        for (int i = 0; i < menus.size(); i++) {
            if (menus.get(i).equals(menu)) {
                return i;
            }
        }
        return -1;
    }

    private void printMenu() {
        System.out.printf(AnsiEscape.ANSI_BOLD_RED +"[%s]\n" + AnsiEscape.ANSI_CLEAR, this.getTitle());

        for (int i = 0; i < menus.size(); i++) {
            System.out.printf("%d. %s\n", (i + 1), menus.get(i).getTitle());
        }

        System.out.printf("0. %s\n", "이전");
    }
}
