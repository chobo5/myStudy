package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어린왕자 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(in.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(in.readLine());
            int sum = 0;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(in.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int startToCenter = (int) Math.pow(cx - x1, 2) + (int) Math.pow(cy - y1, 2);
                int endToCenter = (int) Math.pow(cx - x2, 2) + (int) Math.pow(cy - y2, 2);

                if (startToCenter < Math.pow(r, 2) &&
                        endToCenter > Math.pow(r, 2)) {
                    sum++;
                }

                if (startToCenter > Math.pow(r, 2) &&
                        endToCenter < Math.pow(r, 2)) {
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}
