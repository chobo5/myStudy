package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 터렛 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int distance = (int) Math.pow(x1 - x2, 2) + (int) Math.pow(y1 - y2, 2);

            if (x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
            }

            //외접
            else if (Math.pow(r1 + r2 , 2) == distance) {
                System.out.println(1);
            }

            //네접
            else if (Math.pow(r1 - r2 , 2) == distance) {
                System.out.println(1);
            }

            // 두점이 만남
            else if (distance > Math.pow(r1 + r2, 2)) {
                System.out.println(0);
            }

            else if (distance < Math.pow(r1 -r2, 2)) {
                System.out.println(0);
            }

            else {
                System.out.println(2);
            }

        }
    }
}
