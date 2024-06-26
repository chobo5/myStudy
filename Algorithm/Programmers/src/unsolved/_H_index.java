package unsolved;

import java.util.Arrays;

public class _H_index {
    public static void main(String[] args) {
        class Solution {
            public static int solution(int[] citations) {
                int answer = 0;
                // 0 1 3 5 6
                Arrays.sort(citations);

                for (int i = citations.length - 1; i >= 0; i--) {
                    int h = citations[i];
                    if (h > citations.length) {
                        continue;
                    }
                    if (h <= citations.length - i) {
                        return h;
                    }
                }
                return answer;
            }
        }
        int[] arr = {0, 2, 5, 6 ,8, 10, 11, 23, 45, 1,23, 6, 4, 1 ,6 ,8};
        System.out.println(Solution.solution(arr));
    }
}
