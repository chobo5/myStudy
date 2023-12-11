package bitcamp.menu;

import bitcamp.util.Prompt;

public class MenuGroup implements Menu {
    String title;
    Menu[] menus = new Menu[10];
    int menuSize;

    public MenuGroup(String title) {
        this.title = title;
    }

    @Override
    public void execute(Prompt prompt) {
        this.printMenu();

        while (true) {
            String input = prompt.input("%s> ", this.title);
            int menuNumber = Integer.parseInt(input);
            if (menuNumber < 0 || menuNumber > menuSize) {
                System.out.println("메뉴 번호가 옳지 않습니다.");
                continue;
            } else {
                menus[menuNumber - 1].execute(prompt);
            }

        }

    }

    @Override
    public String getTitle() {
        return title;
    }

    public void add(Menu menu) {
        if (this.menuSize == this.menus.length) {
            int oldSize = this.menus.length;
            int newSize = oldSize + (oldSize >> 1);

            Menu[] arr = new Menu[newSize];
            for (int i = 0; i < oldSize; i++) {
                arr[i] = this.menus[i];
            }

            this.menus = arr;
        }

        this.menus[this.menuSize++] = menu;
    }

    public void remove(Menu menu) {
        int index = indexOf(menu);
        if (index == -1) {
            return;
        }
        for (int i = index; i < menuSize - 1 ; i++) {
            menus[i] = menus[i + 1];
        }
        menus[--this.menuSize] = null;


    }

    private int indexOf(Menu menu) {
        for (int i = 0; i < menuSize; i++) {
            if (menus[i].equals(menu)) {
                return i;
            }
        }
        return -1;
    }

    private void printMenu() {
        System.out.printf("[%s]\n", this.title);

        for (int i = 0; i < this.menuSize; i++) {
            System.out.printf("%d. %s\n", (i + 1), menus[i].getTitle());
        }

        System.out.printf("0. %s\n", "이전");
    }
}