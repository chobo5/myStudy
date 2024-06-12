public class _OX퀴즈 {
    public static void main(String[] args) {
        class Solution {
            public String[] solution(String[] quiz) {
                String[] answer = new String[quiz.length];
                for (int i = 0; i < quiz.length; i++) {
                    String[] strArr = quiz[i].split(" ");
                    int first = Integer.parseInt(strArr[0]);
                    String operator = strArr[1];
                    int second = Integer.parseInt(strArr[2]);
                    int result = Integer.parseInt(strArr[4]);
                    if (operator.equals("+")) {
                        if (first + second == result) {
                            answer[i] = "O";
                        } else {
                            answer[i] = "X";
                        }
                    } else {
                        if (first - second == result) {
                            answer[i] = "O";
                        } else {
                            answer[i] = "X";
                        }
                    }

                }

                return answer;
            }
        }
    }
}
