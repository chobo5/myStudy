import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17484 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] prices = new int[n][m];
        int[][][] dp = new int[n][m][2];


        for (int i = 0; i < prices.length; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < prices[i].length; j++) {
                prices[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    dp[i][j][0] = prices[i][j];
                }
            }
        }
//
//        for (int i = 1; i < dp.length; i++) {
//            for (int j = 0; j < dp[i].length; j++) {
//                if (j == 0) { //제일 왼쪽
//                    if (dp[i][j][1])
//                    dp[i][j][0] = Math.min(dp[i - 1][j][0], dp[i - 1][j + 1][0]) + prices[i][j];
//                } else if (j == dp[i].length - 1) {
//                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + prices[i][j];
//                } else { //제일 오른쪽
//                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1])) + prices[i][j];
//                }
//            }
//        }
//        int min = dp[n - 1][0];
//        for (int i = 1; i < dp[n - 1].length; i++) {
//            min = Math.min(min, dp[n - 1][i]);
//        }
//        System.out.println(min);
    }
}
