public class _연속된수의합 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int num, int total) {
                int[] answer = new int[num];
                int rest = 0;
                for (int i = 1; i < num; i++) {
                    rest += i;
                }

                int x = (total - rest) / num;
                for (int i = 0; i < num; i++) {
                    answer[i] = x + i;
                }

                return answer;
            }
        }
    }
}
