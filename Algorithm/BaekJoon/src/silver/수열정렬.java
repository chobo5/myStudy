package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수열정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] A = new int[n];
        int[] B = new int[n];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {

            A[i] = B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    sb.append(j).append(" ");
                    B[j] = -1;
                    break;
                }
            }
        }
        System.out.println(sb);
    }


}
