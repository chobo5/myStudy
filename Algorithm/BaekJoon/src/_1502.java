import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1502 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] dp = new int[k + 1][2];
        dp[1][0] = 1;
        dp[2][1] = 1;
        for (int i = 3; i <= k; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        int a = dp[k][0];
        int b = dp[k][1];
        int A = 1;
        int B = 1;
        /*
        3A + 5B = 41
        A = 41-5B / 3
        B =
         */
        while ((n - (a * A)) % b != 0) {
            A++;
        }
        B = (n - (a * A)) / b;
        System.out.println(A);
        System.out.println(B);

        /*
        1 A
        2 B
        3 A + B
        4 A + 2B
        5 2A + 3B
        6 3A + 5B
        7 5A + 8B
        8 8A + 13B
        9 13A + 21B
         */
    }
}

// 2 26 28 54 82 136 218