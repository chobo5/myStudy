package unsolved;

public class _소수찾기 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int n) {
                int answer = 1;
                if (n == 2) {
                    return 1;
                }
                for (int i = 3; i <= n; i++) {
                    boolean isPrime = true;
                    for (int j = 1; j <= (int)Math.sqrt(i); j++) {
                        if (j != 1 && i % j == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (isPrime) answer++;
                }
                return answer;
            }
        }
    }
}
