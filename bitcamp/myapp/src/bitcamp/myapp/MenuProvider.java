package bitcamp.myapp;

public class MenuProvider {
    private static final String RESET = "\u001B[0m";
    private static final String FONT_RED_BOLD = "\033[1;31m";
    public static void showMenu(String[] array) {
        System.out.println("[" + FONT_RED_BOLD + array[0] + RESET + "]");
        System.out.println();
        for (int i = 1; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }


}
