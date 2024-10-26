package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int lines = Integer.parseInt(st.nextToken());
        int brands = Integer.parseInt(st.nextToken());

        int set6 = Integer.MAX_VALUE;
        int one = Integer.MAX_VALUE;

        for (int i = 0; i < brands; i++) {
            st = new StringTokenizer(in.readLine());
            set6 = Math.min(set6, Integer.parseInt(st.nextToken()));
            one = Math.min(one, Integer.parseInt(st.nextToken()));
        }

        if (one * 6 <= set6) {
            System.out.println(one * lines);
        } else {
            int rest = (lines % 6) * one > set6 ? set6 : (lines % 6) * one;
            int set = lines / 6;
            System.out.println(set * set6 + rest);
        }

    }
}
