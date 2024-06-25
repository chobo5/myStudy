import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15652 {

    static int n;
    static int m;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        in.close();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        arr = new int[m];
        sb = new StringBuilder();
        dfs(0, 1);
        System.out.println(sb);

    }

    public static void dfs(int depth, int start) {
        if (depth == m) {
            for (int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            dfs(depth + 1, i);


        }
    }
}
