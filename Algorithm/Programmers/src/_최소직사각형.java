public class _최소직사각형 {
    class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;
            int maxWidth = 0;
            int maxHeight = 0;
            for (int i = 0; i < sizes.length; i++) {
                int width = sizes[i][0];
                int height = sizes[i][1];
                if (height > width) {
                    sizes[i][0] = height;
                    sizes[i][1] = width;
                }
                maxWidth = Math.max(maxWidth, sizes[i][0]);
                maxHeight = Math.max(maxHeight, sizes[i][1]);
            }
            return maxWidth * maxHeight;
        }
    }
}
