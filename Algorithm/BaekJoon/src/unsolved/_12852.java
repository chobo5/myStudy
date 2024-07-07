package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        in.close();
        StringBuilder sb = new StringBuilder();
        sb.append(n).append(" ");
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        if (n >= 2) {
            dp[2] = 1;
        }
        if (n >= 3) {
            dp[3] = 1;
        }

        for (int i = 4; i < dp.length; i++) {
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i - 1] + 1);
                continue;
            }

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
                continue;
            }

            dp[i] = dp[i - 1] + 1;
        }
        System.out.println(dp[n]);



    }
}
