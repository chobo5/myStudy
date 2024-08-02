package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17069 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] arr = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int status = 0; //0 - 가로, 1 - 세로, 2 - 대각
        int[] endPoint = {0, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if (arr[i][j] == 1) {
                    continue;
                }

                if (i < n - 1 && j < n - 1) {

                }
            }
        }
    }
}
