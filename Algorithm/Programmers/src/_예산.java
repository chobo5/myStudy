import java.util.Arrays;

public class _예산 {
    class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;
            Arrays.sort(d);
            for (int i = 0; i < d.length; i++) {
                int b = d[i];
                if (budget < b) {
                    break;
                }
                budget -= b;
                answer++;
            }
            return answer;
        }
    }
}
