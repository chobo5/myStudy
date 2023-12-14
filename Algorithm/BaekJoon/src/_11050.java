import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = factorial(n) / (factorial(n - k) * factorial(k));
        System.out.println(result);

    }

    static int factorial(int num) {
        int num1 = num;
        int temp = 1;
        while (num1 > 0) {
            temp *= num1;
            num1--;
        }
        return temp;
    }
}
