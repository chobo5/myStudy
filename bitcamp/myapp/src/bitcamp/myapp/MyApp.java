package bitcamp.myapp;

import bitcamp.myapp.menu.ui.MainMenu;
import bitcamp.util.Prompt;

public class MyApp {

    public static void main(String[] args) {
        Prompt prompt = new Prompt();
//        MainMenu mainMenu = new MainMenu(prompt);
//        mainMenu.execute();
        new MainMenu(prompt).execute();
        prompt.close();
    }
}