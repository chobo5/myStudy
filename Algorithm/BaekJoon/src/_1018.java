import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            String str = br.readLine();
            for (int j = 0; j < y; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                };
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < x - 7; i++) {
            for (int j = 0; j < y - 7; j++) {
                int count = readCheckBoard(i, j, arr);
                min = Math.min(min, count);
            }
        }

         System.out.println(min);
    }

    private static int readCheckBoard(int startX, int startY, boolean[][] arr) {
        int endX = startX + 8;
        int endY = startY + 8;
        boolean first = arr[startX][startY];
        int count = 0;

        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                if (arr[i][j] != first) {
                    count++;
                }
                first = !first;
            }
            first = !first;
        }
        return Math.min(count, 64 - count);
    }
}
