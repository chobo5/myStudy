package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        in.close();
        long n = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        List<Integer> remainArr = new ArrayList<>();


        while (n > 0) {
            remainArr.add((int)(n % b));
            n = n / b;
        }

        StringBuilder sb = new StringBuilder();
        if (b >= 10) {
            for (int num : remainArr) {
                if (num > 9) {
                    sb.append((char)(num - 10 + 'A'));
                } else {
                    sb.append(num);
                }
            }
        } else {
            remainArr.forEach((integer) -> sb.append(integer));
        }

        System.out.println(sb);



    }
}
