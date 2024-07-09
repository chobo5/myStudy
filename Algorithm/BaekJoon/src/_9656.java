import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9656 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        in.close();
        if (n % 2 == 0) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
        /*
        1 CY
        12 SK
        123 CY
        1234 SK
         */

    }
}
