public class _행렬의곱셈 {
    public static void main(String[] args) {
        class Solution {
            public int[][] solution(int[][] arr1, int[][] arr2) {
                int[][] answer = new int[arr1.length][arr2[0].length];

                for (int i = 0; i < answer.length; i++) {
                    for (int j = 0; j < answer[0].length; j++) {
                        int temp = 0;
                        for (int k = 0; k < arr2.length; k++) {
                            temp += arr1[i][k] * arr2[k][j];
                        }
                        answer[i][j] = temp;
                    }
                }
                return answer;
            }
        }
    }
}
