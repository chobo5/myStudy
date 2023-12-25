import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
//            int[] tempArr = new int[b - a + 1];
            for (int j = a; j <= a +((b - a) / 2); j++) {
                int temp = arr[j];
                arr[j] = arr[b + a - j];
                arr[b + a - j] = temp;
            }

        }

        for(int x : arr) {
            System.out.print(x + " ");
        }
    }
}
//12345
//21345
//21435
//34125

