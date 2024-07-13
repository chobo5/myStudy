import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _15654 {

    static int n;
    static int m;
    static int[] arr;

    static int[] temp;
    static boolean[] check;
    static StringBuilder answer;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        temp = new int[m];
        check = new boolean[n];
        answer = new StringBuilder();

        st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0);
        System.out.println(answer);

    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                answer.append(temp[i]).append(" ");
            }
            answer.append("\n");
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
