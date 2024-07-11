package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4811 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(in.readLine());

            if (n == 0) {
                break;
                //W - n개, H - n개인데 H는 W를 꺼낸 이후에만 가능
                /*
                n = 1) WH - 1개
                n = 2) WHWH, WWHH 2개
                n = 3) WH만 더함 2개 + WWWHHH, WHWWHH, WWHWHH 5개
                n = 4) 5개 + 3 +  14개
                n = 5)
                n = 6)
                 */
            }


        }
        in.close();

    }
}
