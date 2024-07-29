import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17618 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (i % calculateSum(i) == 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static int calculateSum(int x) {
        int sum = 0;
        while (x >= 10) {
            sum += x % 10;
            x /= 10;
        }
        return sum + x;
    }
}
