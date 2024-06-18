public class _캐릭터의좌표 {
    class Solution {
        public int[] solution(String[] keyinput, int[] board) {
            int[] answer = {0, 0};
            for (int i = 0; i < keyinput.length; i++) {
                int width = (board[0] - 1) / 2;
                int height = (board[1] - 1) / 2;
                String dir = keyinput[i];
                if (dir.equals("up")) {
                    answer[1]++;
                } else if (dir.equals("down")) {
                    answer[1]--;
                } else if (dir.equals("left")) {
                    answer[0]--;
                } else {
                    answer[0]++;
                }

                if (answer[0] > width) {
                    answer[0] = width;
                } else if (answer[0] < -width) {
                    answer[0] = -width;
                }

                if (answer[1] > height) {
                    answer[1] = height;
                } else if (answer[1] < -height) {
                    answer[1] = -height;
                }

            }
            return answer;
        }
    }
}
