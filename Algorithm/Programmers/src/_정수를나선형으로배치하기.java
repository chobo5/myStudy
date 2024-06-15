public class _정수를나선형으로배치하기 {
    public static void main(String[] args) {
        class Solution {
            public int[][] solution(int n) {
                int[][] answer = new int[n][n];
                int num = 1;
                int startColumn = 0;
                int startRow = 0;
                int endColumn = n - 1;
                int endRow = n - 1;
                while (num <= n * n) {
                    for (int i = startColumn; i <= endColumn; i++) {
                        answer[startRow][i] = num;
                        num++;
                    }
                    startRow++;


                    for (int i = startRow; i <= endRow; i++) {
                        answer[i][endColumn] = num;
                        num++;
                    }
                    endColumn--;

                    for (int i = endColumn; i >= startColumn ; i--) {
                        answer[endRow][i] = num;
                        num++;
                    }
                    endRow--;

                    for (int i = endRow; i >= startRow; i--) {
                        answer[i][startColumn] = num;
                        num++;
                    }
                    startColumn++;
                }
                return answer;
            }
        }
    }
}
