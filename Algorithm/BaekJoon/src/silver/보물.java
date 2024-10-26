package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        Integer[] A = new Integer[n];
        Integer[] B = new Integer[n];

        StringTokenizer st1 = new StringTokenizer(in.readLine());
        StringTokenizer st2 = new StringTokenizer(in.readLine());

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st1.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B, Comparator.reverseOrder());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i] * B[i];
        }

        System.out.println(sum);


    }
}
