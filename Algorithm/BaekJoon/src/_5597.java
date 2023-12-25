import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] students = new int[30];
        for (int i = 0; i < 30; i++) {
            students[i] = i + 1;
        }

        for (int i = 0; i < 28; i++) {
            int x = Integer.parseInt(in.readLine());
            students[x - 1] = 0;
        }
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if (count == 2) {
                break;
            }
            if (students[i] != 0) {
                System.out.println(students[i]);
            }
        }
    }
}
