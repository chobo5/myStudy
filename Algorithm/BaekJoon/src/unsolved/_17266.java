package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine()); // 굴다리의 길이
        int m = Integer.parseInt(in.readLine()); //가로등의 개수
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sb.append(0);
        }
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < m; i++) {
            sb.setCharAt(Integer.parseInt(st.nextToken()), '1');
        }

        String[] arr = sb.toString().split("1");
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || i == arr.length - 1) {
                max = Math.max(max, arr[i].length());
            } else {
                max = Math.max(max, (int) Math.ceil((double) arr[i].length() / 2));
            }
        }
        System.out.println(max);
    }
}
