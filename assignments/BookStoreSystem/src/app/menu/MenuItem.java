package app.menu;

import app.menu.handler.Handler;

public class MenuItem {
    private Handler handler;

    public MenuItem(Handler handler) {
        this.handler = handler;
    }

    void execute() {
        if (this.handler != null) {
            try {
                this.handler.action(this);
            } catch (Exception e) {
                System.out.println("실행 오류!");
            }
        }
    }
}
