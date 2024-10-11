import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        MemberMenu memberMenu = new MemberMenu(in);
        BoardMenu boardMenu = new BoardMenu(in);
        AssignmentMenu assignmentMenu = new AssignmentMenu(in);
        MainMenu mainMenu = new MainMenu(in, boardMenu, assignmentMenu, memberMenu);

        mainMenu.execute();

    }
}