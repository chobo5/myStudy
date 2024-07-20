import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _3040 {
    static int[] arr;
    static int[] temp;
    static boolean[] check;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        temp = new int[7];
        check = new boolean[9];
        sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
        in.close();
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(sb);

    }

    static void dfs(int depth, int start) {
        if (depth == 7) {
            int sum = 0;
            for (int i = 0; i < 7; i++) {
                sum += temp[i];
            }
            if (sum == 100) {
                for (int i = 0; i < 7; i++) {
                    sb.append(temp[i]).append("\n");
                }
                return;
            }
            return;
        }

        for (int i = start; i < 9; i++) {
//            if (!check[i]) {
//                check[i] = true;
                temp[depth] = arr[i];
                dfs(depth + 1, i + 1);
//                check[i] = false;
//            }
        }
    }
}
