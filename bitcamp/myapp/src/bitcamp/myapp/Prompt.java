package bitcamp.myapp;

import java.util.Scanner;

public class Prompt {
    private Scanner sc;

    Prompt() {
        sc = new Scanner(System.in);
    }
    public String getUserInput(String currentPath, String explain) {
        System.out.print(currentPath +">> " + explain);
        return sc.nextLine();
    }

    public int inputInt(String currentPath, String explain) {
        String input = getUserInput(currentPath, explain);
        return Integer.parseInt(sc.nextLine());
    }

    public double inputDouble(String currentPath, String explain) {
        String input = getUserInput(currentPath, explain);
        return Double.parseDouble(sc.nextLine());
    }


    public void close() {
        sc.close();
    }
}
