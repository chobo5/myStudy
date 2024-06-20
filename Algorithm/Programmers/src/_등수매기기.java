import java.util.*;

public class _등수매기기 {
    class Solution {
        public int[] solution(int[][] score) {
            List<Integer> scoreList = new ArrayList<>();
            for (int i = 0; i < score.length; i++) {
                scoreList.add(score[i][0] + score[i][1]);
            }
            scoreList.sort(((o1, o2) -> o2 - o1));

            int[] answer = new int[scoreList.size()];
            for (int i = 0; i < scoreList.size(); i++) {
                answer[i] = scoreList.indexOf(score[i][0] + score[i][1]) + 1;
            }
            return answer;
        }
    }
}
