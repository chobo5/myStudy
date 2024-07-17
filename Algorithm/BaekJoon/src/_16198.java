import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _16198 {
    static int n;
    static List<Integer> list;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        list = new ArrayList<>();
        max = 0;
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        in.close();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        dfs(0, 0);
        System.out.println(max);

    }

    static void dfs(int depth, int sum) {
        if (list.size() == 2) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int temp = list.get(i);
            int value = list.get(i - 1) * list.get(i + 1);
            list.remove(i);
            dfs(depth + 1, sum + value);
            list.add(i, temp);
        }


    }
}
/*
1 2 3 4 // 2 -> 1
8 + 4 // 1 -> 1
2 2 7 6 90 5 9
 */