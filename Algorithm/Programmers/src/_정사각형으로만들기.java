public class _정사각형으로만들기 {
    class Solution {
        public int[][] solution(int[][] arr) {
            int a = arr[0].length;
            int b = arr.length;
            
            if (a > b) {
                int[][] answer = new int[a][a];
                for (int i = 0; i < b; i++) {
                    for (int j = 0; j < a; j++) {
                        answer[i][j] = arr[i][j];
                    }
                }
                return answer;
            } else {
                int[][] answer = new int[b][b];
                for (int i = 0; i < b; i++) {
                    for (int j = 0; j < a; j++) {
                        answer[i][j] = arr[i][j];
                    }
                }
               return answer;
            }
        }
    }
}
