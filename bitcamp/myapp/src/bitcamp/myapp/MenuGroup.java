package bitcamp.myapp;

import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public class MenuGroup implements Menu {

    private Menu[] menus = new Menu[10];
    private int currentLength = 1;
    private String title;

    public MenuGroup(String title, Prompt prompt) {
        this.title = title;
    }

    @Override
    public void execute(Prompt prompt) {
        printMenu();
        while (true) {
            int index = Integer.parseInt(prompt.getUserInput(this.title, ""));
            if (index >= 0 && index < currentLength) {
                menus[index -1].execute(prompt);
            } else {
                System.out.println("존재하지 않는 번호입니다.");
            }

        }

    }

    @Override
    public String getTitle() {
        return this.title;
    }

    public void add(Menu menu) {
        menus[currentLength - 1] = menu;
        currentLength++;
    }

    public void delete(Menu menu) {
        int index = indexOF(menu);
        if (index != -1) {
            for (int i = index; i < currentLength - 1; i++) {
                menus[i] = menus[i + 1];
            }
            menus[currentLength - 1] = null;
            currentLength--;
        } else {
            System.out.println("존재하지 않는 항목입니다.");
        }


    }

    private int indexOF(Menu menu) {
        for (int i = 0; i < currentLength - 1; i++) {
            if (menus[i].equals(menu)) {
                return i;
            }
        }
        return -1;
    }

    private void printMenu() {
        System.out.println("[" + AnsiEscape.FONT_RED_BOLD + title + AnsiEscape.RESET + "]");

        for (int i = 0; i < currentLength - 1; i++) {
            System.out.println((i + 1) + ". " + menus[i].getTitle());
        }

    }
}
