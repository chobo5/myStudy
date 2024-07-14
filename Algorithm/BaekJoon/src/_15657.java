import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15657 {

    static int n;
    static int m;
    static int[] arr;
    static int[] temp;
    static StringBuilder sb;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        temp = new int[m];
        check = new boolean[n];
        sb = new StringBuilder();
        st = new StringTokenizer(in.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        in.close();
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(sb);

    }

    static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            temp[depth] = arr[i];
            dfs(depth + 1, i);
        }
    }
}
/*
dfs(0)
temp[0] = arr[0], temp[0] = arr[1], temp[0] = arr[2], temp[0] = arr[3], temp[0] = arr[4]
dfs(1) * n
temp[1] = arr[0], temp[1] = arr[1], temp[1] = arr[2], temp[1] = arr[3], temp[1] = arr[4]
dfs(2) * n
 */