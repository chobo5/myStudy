import java.util.Stack;

public class _땅따먹기 {
    public static void main(String[] args) {
        class Solution {
            int solution(int[][] land) {
                int answer = 0;
                int[][] dp = new int[land.length][land[0].length];

                for (int i = 0; i < land[0].length; i++) {
                    dp[0][i] = land[0][i];
                }

                for (int i = 1; i < land.length; i++) {
                    for (int j = 0; j < land[i].length; j++) {

                    }
                }

                for (int i = 0; i < dp[dp.length - 1].length; i++) {
                    answer = Math.max(answer, dp[dp.length - 1][i]);
                }

                return answer;
            }
        }


    }
}
