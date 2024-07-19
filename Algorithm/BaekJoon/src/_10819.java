import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10819 {
    static int n;
    static int[] arr;
    static int[] temp;
    static boolean[] check;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        arr  = new int[n];
        temp = new int[n];
        check = new boolean[n];
        max = 0;
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs( 0);
        System.out.println(max);


    }

    static void dfs(int depth) {
        if (depth == n) {
            int result = 0;
            for (int i = 0; i < n - 1; i++) {
                result += Math.abs(temp[i] - temp[i + 1]);
            }
            max = Math.max(result, max);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                temp[depth] = arr[i];
                dfs(depth + 1);
                check[i] = false;
            }
        }
    }
}
