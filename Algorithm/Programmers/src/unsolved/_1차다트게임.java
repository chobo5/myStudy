package unsolved;

public class _1차다트게임 {
    public static void main(String[] args) {
        class Solution {
            public int solution(String dartResult) {
                int answer = 0;
                String[] score = new String[3];
                int order = 0;
                for (int i = 0; i < dartResult.length(); i++) {
                    char c = dartResult.charAt(i);
                    if (c >= '0' && c <= '9') {
                        score[order] = String.valueOf(c);
                    }

                    else if (c == 'S' || c == 'D' || c == 'T') {
                        if (c == 'S') {

                        }
                    }

                }
                return answer;
            }
        }
    }
}
