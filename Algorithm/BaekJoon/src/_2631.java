import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] kids = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            kids[i] = Integer.parseInt(in.readLine());
        }

        in.close();

        int max = 0;
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if(kids[j] < kids[i] && dp[j]+1 > dp[i]) {
                    dp[i] = dp[j]+1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
    }
}
