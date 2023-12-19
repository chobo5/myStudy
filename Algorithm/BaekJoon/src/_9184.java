import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9184 {

    static int[][][] array = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = in.readLine();
            if (line.equals("-1 -1 -1")) {
                break;
            }
            st = new StringTokenizer(line, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int result = w(a, b, c);
            sb.append("w(" + a +", " + b + ", " + c + ") = " + result).append("\n");

        }
        System.out.println(sb);
    }

    static int w(int a, int b, int c) {
        if (inRange(a, b, c) && array[a][b][c] != 0) {
            return array[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return array[20][20][20] = w(20,20,20);
        }

        if (a < b && b < c) {
            return array[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        return array[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);

    }

    static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}
