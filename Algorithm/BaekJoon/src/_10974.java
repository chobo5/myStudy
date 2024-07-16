import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10974 {
    static int n;
    static int[] arr;
    static boolean[] check;
    static int[] temp;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        in.close();
        arr = new int[n];
        check = new boolean[n];
        temp = new int[n];
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        dfs(0);
        System.out.println(sb);



    }

    static void dfs(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
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
