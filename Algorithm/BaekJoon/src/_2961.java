import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _2961 {
    static int n;
    static int[][] taste;
    static List<Integer> list;
    static int[][] tempTaste;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        taste = new int[n][2];
        tempTaste = new int[n][2];
        list = new ArrayList<>();
        isVisited = new boolean[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            dfs(0, i, 0);
        }
        list.sort(((o1, o2) -> o1 - o2));
        System.out.println(list.get(0));

    }

    static void dfs(int depth, int num, int start) {
        if (depth == num) {
            int ssin = 1;
            int sson = 0;
            for (int i = 0; i < num; i++) {
                ssin *= tempTaste[i][0];
                sson += tempTaste[i][1];
            }
            list.add(Math.abs(ssin - sson));
            return;
        }
        for (int i = start; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                tempTaste[depth][0] = taste[i][0];
                tempTaste[depth][1] = taste[i][1];
                dfs(depth + 1, num, i);
                isVisited[i] = false;
            }
        }

    }
}
