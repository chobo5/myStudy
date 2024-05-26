package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1010 {

    static int[][] all = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(combination(m, n)).append("\n");
        }
        System.out.println(sb);
    }

    static int combination(int a, int b) {
        if (all[a][b] > 0) {
            return all[a][b];
        }
        if (a == b || b == 0) {
            return all[a][b] = 1;
        }
        return combination(a - 1, b - 1) + combination(a - 1, b);

    }
}
