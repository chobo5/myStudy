import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1182 {
    static int n;
    static int s;
    static int[] arr;

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        answer = 0;
        st = new StringTokenizer(in.readLine(), " ");
        in.close();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);

        if (s == 0) {
            System.out.println(answer - 1);
        } else {
            System.out.println(answer);
        }
        /*
        -7 -3 -2 5 8
         */
    }

    static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == s) {
                answer++;
            }
            return;
        }

        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }
}
