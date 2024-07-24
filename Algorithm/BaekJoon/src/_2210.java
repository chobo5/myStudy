import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _2210 {
    static int[][] arr;
    static int[][] move;
    static int[] temp;
    static Set<String> set;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        move = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        temp = new int[6];
        set = new HashSet<>();
        sb = new StringBuilder();

        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(0, i, j);
            }
        }
        System.out.println(set.size());
        set.forEach(System.out::println);

    }

    static void dfs(int depth, int startR, int startC) {
        if (depth == 6) {
            for (int i = 0; i < temp.length; i++) {
                sb.append(temp[i]);
            }
            set.add(sb.toString());
            sb.delete(0, sb.length());
            return;
        }

        for (int i = 0; i < 4; i++) {
            int movedR = startR + move[i][0];
            int movedC = startC + move[i][1];
            if (validate(movedR, movedC)) {
                temp[depth] = arr[movedR][movedC];
                dfs(depth + 1, movedR, movedC);
            }
        }
    }

    static boolean validate(int r, int c) {
        return r >= 0 && c >= 0 && r <= 4 && c <= 4;
    }
}
