package unsolved;

public class _뒤에있는큰수찾기 {
    public static void main(String[] args) {
        class Solution {
            public static int[] solution(int[] numbers) {
                int[] answer = new int[numbers.length];

                for (int i = 0; i < numbers.length; i++) {
                    int n = numbers[i];
                    boolean flag = true;
                    int index = i;
                    while (index++ < numbers.length - 1) {
                        if (numbers[index] > n) {
                            answer[i] = numbers[index];
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        answer[i] = -1;
                    }

                }


                return answer;
            }
        }
        int[] numbers = {9, 1, 5, 3, 6, 2};
        System.out.println(Solution.solution(numbers));
    }
}
