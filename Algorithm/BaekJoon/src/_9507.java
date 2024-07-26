import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9507 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        long[] dp = new long[68];
        dp[0] = 1L;
        dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 4L;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int x = Integer.parseInt(in.readLine());
            sb.append(dp[x]).append("\n");
        }
        System.out.println(sb);

    }
}
