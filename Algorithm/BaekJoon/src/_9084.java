import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine(), " ");
            int[] coins = new int[n];
            for (int j = 0; j < n; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }
            int target = Integer.parseInt(in.readLine());
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                for (int k = coin; k < dp.length; k++) {
                    dp[k] += dp[k - coin];
                }
            }
            sb.append(dp[target]).append("\n");
        }
        System.out.println(sb);
    }
}
