package bitcamp.myapp;

import java.util.Scanner;

public class Prompt {
    private static final Scanner sc = new Scanner(System.in);
    public static String getUserInput(String currentPath) {
        System.out.print(currentPath +"> ");
        return sc.nextLine();
    }

    public static void close() {
        sc.close();
    }
}
