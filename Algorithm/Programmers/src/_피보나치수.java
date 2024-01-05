import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _피보나치수 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int n) {
                int answer = 0;
                int[] f = new int[100001];
                f[0] = 0;
                f[1] = 1;
                for (int i = 2; i <= n; i++) {
                    f[i] = f[i -1] % 1234567 + f[i - 2] % 1234567;
                    if (i == n) {
                        answer = f[i] % 1234567;
                    }
                }
                return answer;
            }
        }
    }
}
