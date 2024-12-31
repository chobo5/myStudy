package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = percent(y, x);

        if (x == y || z == 99) {
            System.out.println(-1);
            return;
        }

        z++;
        y = z * (x + a) / 100 - a
    }

    private static int percent(int y, int x) {
        return (y * 100) / x;
    }
}
