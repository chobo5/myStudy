package org.example.menu;


import org.example.menu.handler.Handler;

public class MenuItem {
    private Handler handler;

    private String title;

    public MenuItem(Handler handler, String title) {
        this.handler = handler;
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    void execute() {
        if (this.handler != null) {
            try {
                this.handler.action();
            } catch (Exception e) {
                System.out.println("실행 오류!");
            }
        }
    }
}
