import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] prices = new int[n + 1];
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n + 1];
        dp[0] = prices[0];
        dp[1] = dp[0] + prices[1];
        for (int i = 2; i < n + 1; i++) {
            dp[i] = prices[i];
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[j] + dp[i - j], dp[i]);
            }
        }
        System.out.println(dp[n]);

    }
}
