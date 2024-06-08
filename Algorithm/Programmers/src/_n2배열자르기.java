import java.util.ArrayList;
import java.util.List;

public class _n2배열자르기 {
    public static void main(String[] args) {
        class Solution {
            public static int[] solution(int n, long left, long right) {
                int[] answer = new int[(int)right - (int)left + 1];

                int index = 0;
                for (long i = left; i <= right; i++) {
                    long x = i / n;
                    long y = i % n;
                    answer[index++] = Math.max((int) x, (int) y) + 1;
                }
                return answer;
            }
        }

    }
}
