package unsolved;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.Arrays;
import java.util.Collections;

public class _과일장수 {

    public static void main(String[] args) {
        class Solution {
            public Solution() {
            }

            public int solution(int k, int m, int[] score) {
                int answer = 0;
                int[] scoreArr = score;
                Arrays.sort(scoreArr);
                int count = 0;
                for (int i = 0; i < score.length / m; i++) {
                    int price = score[score.length % m + (m * count++)];
                    answer += price * m;
                }
                return answer;
            }
        }
        int[] arr = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        Solution solution = new Solution();
        System.out.println(solution.solution(4, 3, arr));
    }


}




