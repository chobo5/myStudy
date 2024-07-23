package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _2529 {
    static int n;
    static String[] signs;
    static boolean[] check;
    static int[] temp;
    static List<Long> list;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        signs = new String[n];
        check = new boolean[n + 1];
        temp = new int[n + 1];
        list = new ArrayList<>();
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        in.close();

        for (int i = 0; i < n; i++) {
            signs[i] = st.nextToken();
        }

        dfs(0);
        list.sort(((o1, o2) -> (int) (o1 - o2)));
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));

    }

    static void dfs(int depth) {
        if (depth == n + 1) {
            sb.append(temp[0]);
            for (int i = 1; i < temp.length; i++) {
                sb.append(temp[i]);
            }
            list.add(Long.parseLong(sb.toString()));
            sb.delete(0, sb.length() - 1);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (depth == 0) {
                check[i] = true;
                temp[depth] = i;
                dfs(depth + 1);
                check[i] = false;
            } else if (!check[i] && check(temp[depth - 1], i, signs[depth - 1])) {
                check[i] = true;
                temp[depth] = i;
                dfs(depth + 1);
                check[i] = false;
            } else {
                return;
            }

        }
    }

    static boolean check(int a, int b, String sign) {
        if (sign.equals(">")) {
            if (a > b) {
                return true;
            }
        } else {
            if (a < b) {
                return true;
            }
        }
        return false;
    }
}
