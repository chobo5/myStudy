
public class _방문길이 {
    class Solution {
        public int solution(String dirs) {
            int answer = 0;
            int[][] map = new int[11][11];
            int x = 5;
            int y = 5;
            for (int i = 0; i < dirs.length(); i++) {
                char direction = dirs.charAt(i);
                if (direction == 'U') {
                    x = x == 0 ? x : x - 1;
                }else if (direction == 'D') {
                    x = x == 10 ? x : x + 1;
                } else if (direction == 'R') {
                    y = y == 10 ? y : y + 1;
                } else {
                    y = y == 0 ? y : y - 1;
                }

                if (map[x][y] == 0) {
                    answer++;
                }
                map[x][y] = 1;
            }

            return answer;
        }
    }
}
