public class _기사단원의무기 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int number, int limit, int power) {
                int answer = 0;
                int[] arr = new int[number + 1];
                for (int i = 1; i <= number; i++) {
                    int standard = (int) Math.floor(Math.pow(i, 0.5));
                    int count = 0;
                    for (int j = 1; j <= standard; j++) {
                        if (i % j == 0) {
                            count++;
                        }
                    }
                    if (i != 1) {
                        if (i  == standard * standard) {
                            count = count * 2 - 1;
                        } else {
                            count *= 2;
                        }
                    }

                    arr[i] = count;
                }

                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] > limit) {
                        answer += power;
                    } else {
                        answer += arr[i];
                    }
                }
                return answer;
            }
        }

        Solution solution = new Solution();
        System.out.println(solution.solution(5, 3, 2));
    }
}
