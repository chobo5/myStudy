public class _소수찾기 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int n) {
                int answer = 0;

                for (int i = 2; i <= n; i++) {
                    int sqrt = (int) Math.floor(Math.sqrt(i));
                    boolean flag = true;
                    for (int j = 2; j <= sqrt; j++) {
                        if (i % j == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        answer++;
                    }
                }
                return answer;
            }
        }
    }
}
