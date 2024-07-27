import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] hp = new int[n + 1];
        int[] joys = new int[n + 1];
        StringTokenizer st1 = new StringTokenizer(in.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(in.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            hp[i] = Integer.parseInt(st1.nextToken());
            joys[i] = Integer.parseInt(st2.nextToken());
        }
        in.close();

        int[][] dp = new int[n + 1][100];


        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < 100; j++) { //체력
                if (hp[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - hp[i]] + joys[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][99]);
        /*
        1 20

        21 Math.max(20, 30)
        22 Math.max(dp[21],

        79
         */


    }
}
