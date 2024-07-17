import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18429 {
    static int n;
    static int minus;
    static int[] arr;
    static int[] temp;
    static boolean[] check;
    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        arr = new int[n];
        temp = new int[n];
        check = new boolean[n];
        answer = 0;

        st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs( 0);
        System.out.println(answer);

    }

    static void dfs(int depth) {
        if (depth == n) {
            int weight = 500;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                weight = weight + temp[i] - minus;
                if (weight < 500) {
                    flag = false;
                }
            }
            if (flag) {
                answer++;
            }
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
