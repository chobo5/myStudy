package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(in.readLine());
            int[] dp = new int[n + 1];
            dp[1] = 1;
            if (n >= 2) {
                dp[2] = 2;
            }

            if (n >=3) {
                dp[3] = 3;
            }
            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j - 2] + dp[j - 3];
            }
            System.out.println(dp[n]);

        }

        /*
        0
        1 = 1   1
        2 = 1+1,  /2  2
        3 = 1+1+1, 2+1, / 3   3
        4 = 1+1+1+1, 2+1+1, 3+1, / 2+2    4
        5 = 1+1+1+1+1, 2+2+1, 2+1+1+1, 3+1+1, / 3+2   5
        6 = 1+1+1+1+1+1, 2+2+1+1, 2+1+1+1+1, 3+1+1+1, 3+2+1,/ 3+3, 2+2+2 7
        7 =  6 + 2/ 3+2+2,   8
        8 = 8 + 2+2+2+2, 3+3+2,
        dp[n] = dp[n - 2] + dp[n - 3]

        {
        000

        }
         */
    }
}
