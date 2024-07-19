import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15664 {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] check;
    static int[] temp;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        check = new boolean[n];
        temp = new int[m];
        sb = new StringBuilder();

        st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);

    }

    static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < temp.length; i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = start; i < n; i++) {
            int now = arr[i];
            if (before == now || check[i]) {
                continue;
            } else {
                before = now;
                check[i] = true;
                temp[depth] = arr[i];
                dfs(depth + 1, i);
                check[i] = false;
            }
        }
    }
}
