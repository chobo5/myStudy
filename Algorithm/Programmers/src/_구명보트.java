import java.util.Arrays;

public class _구명보트 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] people, int limit) {
                int answer = 0;
                int[] peoples = people;
                Arrays.sort(peoples);
                int s = 0;
                for (int i = peoples.length - 1; i >= s; i--) {
                    if (peoples[i] + peoples[s] <= limit) {
                        answer++;
                        s++;
                    } else {
                        answer++;
                    }

                }
                return answer;
            }
        }
        int[] test = {70, 50, 80, 50};
        System.out.println(new Solution().solution(test, 100));
    }
}
