import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _16938 {
    static int N, L, R, X;
    static int[] arr;
    static int[] temp;
    static boolean[] check;
    static int answer;

    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        temp = new int[N];
        check = new boolean[N];
        answer = 0;
        sb = new StringBuilder();
        st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 2; i <= N; i++) {
            dfs(0, i, 0);
        }
        System.out.println(answer);


    }

    static void dfs(int depth, int num, int start) {
        if (depth == num && (temp[num - 1] - temp[0] >= X)) {
            int sum = 0;
            for (int i = 0; i < num; i++) {
                sum += temp[i];
            }
            if (sum >= L && sum <= R) {
                answer++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                temp[depth] = arr[i];
                dfs(depth + 1, num, i);
                check[i] = false;
            }
        }
    }
}
