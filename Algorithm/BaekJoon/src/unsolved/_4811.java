package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4811 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[][] dp = new int[31][31];
        dp[1][1] = 1;
        /*
        1 - WH 1개
        2 - WHWH, WWHH 2개

        3 - WHWHWH, WHWWHH,WWHHWH, WWHWHH, WWWHHH 5개
        4 - 14개
         */


    }
}
