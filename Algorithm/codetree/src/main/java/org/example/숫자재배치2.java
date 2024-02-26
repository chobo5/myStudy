package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자재배치2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        String str = in.readLine();
        in.close();
        StringTokenizer st = new StringTokenizer(str," ");
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
        }

        for (int i = n-1; i >= 0 ; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
