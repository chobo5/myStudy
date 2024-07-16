import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _5568 {
    static int n;
    static int k;
    static String[] arr;
    static boolean[] check;
    static String[] temp;
    static Set<Integer> set;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        k = Integer.parseInt(in.readLine());
        arr = new String[n];
        check = new boolean[n];
        temp = new String[k];
        set = new HashSet<>();
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            arr[i] = in.readLine();
        }

        dfs(0);
        System.out.println(set.size());



    }

    static void dfs(int depth) {
        if (depth == k) {
            for (int i = 0; i < k; i++) {
                sb.append(temp[i]);
            }
            set.add(Integer.parseInt(sb.toString()));
            sb.delete(0, sb.length());
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
