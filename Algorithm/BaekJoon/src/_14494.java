import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14494 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] arr = new long[n][m];
        long divide = 1000000007;
        for (int i = 0; i < m; i++) {
            arr[0][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            arr[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j] + arr[i][j - 1]) % divide;
            }
        }
        System.out.println(arr[n - 1][m - 1]);
    }
}
