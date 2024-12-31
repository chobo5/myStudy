package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        in.close();
        for (int i = 0; i < n; i++) {
            arr[i][0] = i + 1; //자신의 키
            arr[i][1] = Integer.parseInt(st.nextToken()); // 자기보다 키큰사람의 수

        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i][0]).append(" ");
        }

        System.out.println(sb);
    }
}

/*
1 2 3 4 5 6 7
6 1 1 1 2 0 0
 */