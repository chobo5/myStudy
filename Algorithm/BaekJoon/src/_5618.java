import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5618 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        in.close();
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            min = Math.min(min, x);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= min; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] % i != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
