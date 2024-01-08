package unsolved;

public class _뒤에있는큰수찾기 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int[] numbers) {
                int[] answer = new int[numbers.length];
                for (int i = 0; i < numbers.length; i++) {
                    for (int j = i; j < numbers.length; j++) {
                        if (numbers[j] > numbers[i]) {
                            answer[i] = numbers[j];
                            break;
                        }
                    }
                    if (answer[i] == 0) {
                        answer[i] = -1;
                    }
                }
                return answer;
            }
        }
    }
}
