import java.util.Arrays;

public class _GeneratingMinimunValue {
    public static void main(String[] args) {
        class Solution
        {
            public int solution(int []A, int []B)
            {
                int answer = 0;
                int[] A1 = A;
                int[] B1 = B;
                Arrays.sort(A1);
                Arrays.sort(B1);
                for (int i = 0; i < A1.length; i++) {
                    answer += A1[i] * B1[B1.length -1 - i];
                }
                // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

                return answer;
            }
        }
    }
}
