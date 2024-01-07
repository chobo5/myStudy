public class _멀리뛰기 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int n) {
                int answer = 0;
                int[] f = new int[100001];
                f[0] = 1;
                f[1] = 2;
                if (n -1 < 2) {
                    return f[n - 1];
                }
                for (int i = 2; i <= n - 1; i++) {
                    f[i] = f[i -1] % 1234567 + f[i - 2] % 1234567;
                    if (i == n - 1) {
                        answer = f[i] % 1234567;
                    }
                }
                return answer;
            }
        }
    }
}
