import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _16922 {
    static int n;
    static int[] arr;
    static int[] temp;
    static Set<Integer> set;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        in.close();
        arr = new int[]{1, 5, 10, 50};
        set = new HashSet<>();
        temp = new int[n];

        dfs(0, 0);
        System.out.println(set.size());

    }

    static void dfs(int depth, int start) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < temp.length; i++) {
                sum += temp[i];
            }
            set.add(sum);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            temp[depth] = arr[i];
            dfs(depth + 1, i);
        }
    }
}
