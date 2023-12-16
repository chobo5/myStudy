import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _27433 {
    static long temp = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        in.close();
        factorial(n);
        System.out.println(temp);

    }

    static void factorial(int num) {
        if (num > 1) {
            temp *= num;
            factorial(num - 1);
        }
    }
}
