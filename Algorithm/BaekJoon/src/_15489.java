import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15489 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int R = Integer.parseInt(st.nextToken()) - 1;
        int C = Integer.parseInt(st.nextToken()) - 1;
        int W = Integer.parseInt(st.nextToken());
        int[][] arr = new int[R + W][R + W];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || i == j) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }

        int index = 1;
        int sum = 0;
        for (int i = R; i < R + W; i++) {
            for (int j = C; j < C + index; j++) {
                sum += arr[i][j];
            }
            index++;
        }
        System.out.println(sum);
    }
}
