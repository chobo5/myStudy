import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        in.close();
        int[] dp = new int[n + 1];
        dp[1] = 1; // l
        dp[2] = 2; // =, ll
        dp[3] = 3; // =l, l=, lll
        dp[4] = 5; // =ll,l=l,=ll,llll, ====

    }
}
