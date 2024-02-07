import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _모의고사 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int[] answers) {

                int[] one = {1, 2, 3, 4, 5}; //12345
                int[] two = {2, 1, 2, 3, 2, 4, 2, 5}; //21 23 24 25
                int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 33 11 22 44 55
                int[] scores = {0, 0, 0};
                for (int i = 0; i < answers.length; i++) {
                    int ans = answers[i];
                    if (one[i % 5] == ans) scores[0]++;
                    if (two[i % 8] == ans) scores[1]++;
                    if (two[i % 10] == ans) scores[2]++;
                }
                List<Integer> list = new ArrayList<>();
                int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
                for (int i = 0; i < 3; i++) {
                    if (scores[i] == max) list.add(i+1);
                }

                int[] answer = new int[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    answer[i] = list.get(i);
                }

                return answer;
            }
        }
    }
}
