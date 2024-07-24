package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1189 {
    static int r;
    static int c;
    static int k;
    static String[][] arr;
    static int[][] move;
    static int[][] temp;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new String[r][c];
        move = new int[][]{{0, 1}, {-1, 0}};
        temp = new int[k][2];
        count = 0;

        for (int i = 0; i < r; i++) {
            String line = in.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = String.valueOf(line.charAt(j));
            }
        }

        dfs(0, r - 1, 0);
        System.out.println(count);

    }

    static void dfs(int depth, int startR, int startC) {
        if (depth == k) {
            if (temp[k - 1][0] == 0 && temp[k - 1][1] == c - 1) {
                count++;
            }
            for (int i = 0; i < temp.length; i++) {
                System.out.print(temp[i][0]);
                System.out.print(" ");
                System.out.print(temp[i][1]);
                System.out.println();
            }
            System.out.println("--------------");
            return;
        }

        for (int i = 0; i < 2; i++) {
            int movedR = startR + move[i][0];
            int movedC = startC + move[i][1];
            if (validate(movedR, movedC) && !arr[movedR][movedC].equals("T")) {
                temp[depth][0] = movedR;
                temp[depth][1] = movedC;
                dfs(depth + 1, movedR, movedC);
            }
        }
    }

    static boolean validate(int a, int b) {
        return a >= 0 && b >= 0 && a < r && b < c;
    }
}

