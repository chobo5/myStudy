public class _안전지대 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[][] board) {
                int answer = 0;
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board.length; j++) {
                        if (board[i][j] == 1) {
                            checkDanger(i , j, board);
                        }
                    }
                }

                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board.length; j++) {
                        if (board[i][j] == 0) {
                            answer++;
                        }
                    }
                }
                return answer;
            }

            public void checkDanger(int a, int b, int[][] board) {
                for (int i = a - 1; i <= a + 1 ; i++) {
                    for (int j = b - 1; j <= b + 1 ; j++) {
                        int n = board.length;
                        if (i > n - 1 || i < 0 || j > n - 1 || j < 0) {
                            continue;
                        }
                        if (board[i][j] == 0) {
                            board[i][j] = 2;
                        }
                    }
                }
            }
        }
    }
}

/*
[
[0, 0, 0, 0, 0],
[0, 0, 0, 0, 0],
[0, 0, 0, 0, 0],
[0, 0, 1, 1, 0],
[0, 0, 0, 0, 0]
]
 */