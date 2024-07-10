import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] dp = new int[n][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 9; k >= 1; k++) {
                    dp[i][j] += k - j;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n - 1][i];
        }
        System.out.println(sum % 10007);
        /*
        1 2 3 4 5 6 7 8 9 10
        10 19 27 34 40 45 49 52 54 55
        55 45+55 55+45+36 ...
         */


    }
}
