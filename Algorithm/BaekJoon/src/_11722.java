import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int[] arr = new int[n];
        int[] arr2 = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[i] = 1;
        }
        

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if (x > arr[j] && arr2[i] <= arr2[j]) {
                    arr2[i] = arr2[j] + 1;
                } else if (x == arr[j]) {
                    arr2[i] = arr2[j];
                }
            }
        }

        int max = 1;
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] > max) {
                max = arr2[i];
            }
        }
        System.out.println(max);







    }
}
