public class _분수의덧셈 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int numer1, int denom1, int numer2, int denom2) {
                int[] answer = new int[2];
                int denom = denom1 * denom2;
                int numer = (numer1 * denom2) + (numer2 * denom1);

                int gcd = gcd(denom, numer);

                answer[0] = numer / gcd;
                answer[1] = denom / gcd;
                return answer;
            }

            public int gcd(int a, int b) {
                if (b == 0) {
                    return a;
                }
                return gcd(b, a % b);
            }
        }
    }
}
