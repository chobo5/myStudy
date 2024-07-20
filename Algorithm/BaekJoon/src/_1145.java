import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1145 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        in.close();
        for (int i = 0; i < 5; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int first = arr[0];
        while (true) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                if (first % num == 0) {
                    count++;
                }
            }
            if (count >= 3) {
                System.out.println(first);
                return;
            } else {
                first++;
            }
        }
    }
}
