import java.util.ArrayList;
import java.util.List;

public class _크레인인형뽑기 {
    public static void main(String[] args) {
        class Solution {
            public static int solution(int[][] board, int[] moves) {
                int answer = 0;
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < moves.length; i++) {
                    int move = moves[i] - 1;
                    for (int j = 0; j < board.length; j++) {
                        if (board[j][move] != 0) {
                            int doll = board[j][move];
                            board[j][move] = 0;

                            if (!list.isEmpty() && list.get(list.size() - 1) == doll) {
                                list.remove(list.size() - 1);
                                answer++;
                                break;
                            }
                            list.add(doll);
                            break;
                        }
                    }
                }

                return answer * 2;
            }

        }
        int[][] boards = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(Solution.solution(boards, moves));
    }
}
