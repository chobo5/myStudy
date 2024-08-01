import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14495 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        in.close();
        if (n == 1 || n == 2 || n == 3) {
            System.out.println(1);
            return;
        }

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }

        System.out.println(dp[n]);

    }
}
