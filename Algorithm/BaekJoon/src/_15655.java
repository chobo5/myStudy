import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15655 {

    static int n;
    static int m;
    static int[] arr;

    static int[] temp;
    static boolean[] check;
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
        in.close();

        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(sb);

    }

    static void dfs(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < temp.length; i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (!check[i]) {
                temp[depth] = arr[i];
                check[i] = true;
                dfs(i, depth + 1);
                check[i] = false;
            }
        }
    }
}
