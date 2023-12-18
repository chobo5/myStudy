import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        boolean[][] board = new boolean[100][100];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            String line = in.readLine();
            st = new StringTokenizer(line, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10 ; j++) {
                for (int k = y; k < y + 10; k++) {
                    board[j][k] = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (board[i][j]) {
                    count += 1;
                }
            }
        }
        System.out.println(count);


    }
}
