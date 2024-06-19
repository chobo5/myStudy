import java.util.Arrays;

public class _직사각형넓이구하기 {
    class Solution {
        public int solution(int[][] dots) {
            int answer = 0;
            Arrays.sort(dots, ((o1, o2) -> o1[0] - o2[0]));
            int height = Math.abs(dots[0][0] - dots[2][0]);
            int width = Math.abs(dots[0][1] - dots[1][1]);
            return width * height;
        }
    }
}
