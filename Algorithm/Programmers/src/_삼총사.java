public class _삼총사 {
    class Solution {
        public int solution(int[] number) {
            int answer = 0;
            for (int i = 0; i < number.length - 2; i++) {
                int x = number[i];
                for (int j = i + 1; j < number.length - 1; j++) {
                    int y = number[j];
                    for (int k = j + 1; k < number.length; k++) {
                        int z = number[k];
                        if (x + y + z == 0) {
                            answer++;
                        }
                    }
                }
            }
            return answer;
        }
    }
}
