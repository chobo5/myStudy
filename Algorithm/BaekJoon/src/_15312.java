import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15312 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String A = in.readLine();
        String B = in.readLine();
        int[] counts = new int[] {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        in.close();
        int[][] arr = new int[A.length() + B.length() - 1][A.length() + B.length()];
        int index = 0;
        for (int i = 0; i < A.length(); i++) {
            int a = counts[(int) A.charAt(i) - 'A'];
            arr[0][index] = a;
            index++;
            int b = counts[(int) B.charAt(i) - 'A'];
            arr[0][index] = b;
            index++;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i + 1; j++) {
                arr[i][j] = (arr[i - 1][j] + arr[i - 1][j + 1]) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr[arr.length - 1][0]).append(arr[arr.length - 1][1]);
        System.out.println(sb);

    }
}
