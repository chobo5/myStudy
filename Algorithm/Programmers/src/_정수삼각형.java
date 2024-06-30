public class _정수삼각형 {
    class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            int[][] dp = new int[triangle.length][triangle.length];
            dp[0][0] = triangle[0][0];
            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = dp[i - 1][0] + triangle[i][0];
            }

            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < triangle[i].length; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]);
                }
            }

            for (int i = 0; i < dp[triangle.length - 1].length; i++) {
                answer = Math.max(answer, dp[triangle.length - 1][i]);
            }
            return answer;
        }
    }
}
