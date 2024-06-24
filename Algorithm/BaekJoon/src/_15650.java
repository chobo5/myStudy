import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650 {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        in.close();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n];
        sb = new StringBuilder();
        dfs(0,0);
        System.out.println(sb);

    }

    public static void dfs(int start, int depth) {
        if (depth == m) {
            for(int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

}
