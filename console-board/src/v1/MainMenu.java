package v1;

import java.io.BufferedReader;
import java.io.IOException;

public class MainMenu {
    private BufferedReader in;
    private Menu[] menus;

    public MainMenu(BufferedReader in, Menu... menus) {
        this.in = in;
        this.menus = menus;
    }

    public void execute() throws IOException {
        System.out.println("콘솔 게시판 프로그램 시작");

        while(true) {

            for (int i = 1; i <= menus.length; i++) {
                System.out.println(i + ". " + menus[i - 1].getName());
            }

            int menuNo = Integer.parseInt(in.readLine()) - 1;
            if (menuNo > menus.length - 1) {
                System.out.println("존재하지 않는 메뉴입니다.");
                continue;
            }

            menus[menuNo].execute();

        }
    }
}
