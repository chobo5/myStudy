public class _문자열여러번뒤집기 {
    public static void main(String[] args) {
        class Solution {
            public static String solution(String my_string, int[][] queries) {
                String[] answer = my_string.split("");
                for (int i = 0; i < queries.length; i++) {
                    int mid = (queries[i][1] + queries[i][0]) / 2;
                    int range = queries[i][0] + queries[i][1];
                    for (int j = queries[i][0]; j <= mid; j++) {
                        String temp = answer[j];
                        answer[j] = answer[range - j];
                        answer[range - j] = temp;
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (String a : answer) {
                    sb.append(a);
                }
                return sb.toString();
            }
        }

        int[][] queries = {{2, 3}, {0, 7}, {5, 9}, {6, 10}};
        System.out.println(Solution.solution("rermgorpsam", queries));
    }

}
