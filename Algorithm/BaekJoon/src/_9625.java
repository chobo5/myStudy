import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9625 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        in.close();
        int[][] dp = new int[n + 1][2]; //B -> BA, A -> B
        dp[0][0] = 1;
        dp[1][1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        System.out.println(dp[n][0] + " " + dp[n][1]);
        /*
        A 10
        B 01
        BA 11
        BAB 12
        BABBA
        BABBABAB
         */

    }
}
