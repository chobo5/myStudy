import java.util.Arrays;

public class _H_index {
    public static void main(String[] args) {
        class Solution {
            public static int solution(int[] citations) {
                int answer = 0;
                // 0 1 3 5 6
                Arrays.sort(citations);

                for (int i = 0; i < citations.length; i++) {
                    int h = citations.length - i;
                    if (citations[i] >= h) {
                        return h;
                    }
                }
                return answer;
            }
        }
        int[] arr = {3, 0, 6, 1, 5, 4, 4};
        System.out.println(Solution.solution(arr));
    }
}
