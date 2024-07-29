import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2548 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int min = Integer.MAX_VALUE;
        int max = 0;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            min = Math.min(min, x);
            max = Math.max(max, x);
            arr[i] = x;
        }
        int p = Integer.MAX_VALUE;
        int value = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += Math.abs(arr[j] - i);
            }
            if (value > sum) {
                p = i;
                value = sum;
            }
        }
        System.out.println(p);
    }
}
