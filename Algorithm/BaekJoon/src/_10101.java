import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10101 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());
        int c = Integer.parseInt(in.readLine());
        in.close();
        if (a + b + c == 180) {
            if (a == 60 && b == 60 && c == 60) {
                System.out.println("Equilateral");
            } else if (a == b || b == c || a == c) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        } else {
            System.out.println("Error");
        }

    }
}
