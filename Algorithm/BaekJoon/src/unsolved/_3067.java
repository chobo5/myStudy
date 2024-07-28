package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3067 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(in.readLine());
            int[] coins = new int[n];
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < n; j++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int target = Integer.parseInt(in.readLine());

            sb.append(dp(coins, target)).append("\n");

        }
        System.out.println(sb);
    }

    public static int dp(int[] coins, int target) {
        int[][] dp = new int[coins.length][target + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (j < coins[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] += dp[i - 1][j] + dp[i][j - coins[i]];
                }
            }
        }
        return dp[coins.length - 1][target];
    }
}
