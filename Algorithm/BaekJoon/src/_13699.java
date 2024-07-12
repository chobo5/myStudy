import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13699 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        long[] dp = new long[n + 1];
        dp[0] = 1L;
        if (n >= 1) {
            dp[1] = dp[0] * dp[0];
        }
//        dp[2] = dp[0]*dp[1] + dp[1]*dp[0];
        //dp[n] = dp[0]*dp[n-1] + dp[1]*dp[n-2] + ...+ dp[n-1]*dp[0];

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        System.out.println(dp[n]);
    }
}
