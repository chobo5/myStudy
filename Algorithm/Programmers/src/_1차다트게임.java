import java.util.ArrayList;
import java.util.List;

public class _1차다트게임 {
    public static void main(String[] args) {
        class Solution {
            public int solution(String dartResult) {
                int answer = 0;
                List<Integer> scores = new ArrayList<>();
                for (int i = 0; i < dartResult.length(); i++) {
                    char c = dartResult.charAt(i);

                    if (isNum(c)) {
                        if (dartResult.charAt(i + 1) == '0') {
                            scores.add(10);
                            i++;
                        } else {
                            scores.add((int) c - 48);
                        }
                    } else if (isArea(c)) {
                        int score = scores.get(scores.size() - 1);
                        if (c == 'D') {
                            scores.set(scores.size() - 1, (int) Math.pow(score, 2));
                        } else if (c == 'T') {
                            scores.set(scores.size() - 1, (int) Math.pow(score, 3));
                        }
                    } else {

                        if (c == '*') {
                            if (scores.size() == 1) {
                                scores.set(0, scores.get(0) * 2);
                            } else {
                                for (int j = scores.size() - 2; j < scores.size(); j++) {
                                    scores.set(j, scores.get(j) * 2);
                                }
                            }

                        }

                        if (c == '#') {
                            scores.set(scores.size() - 1, scores.get(scores.size() - 1) * -1);
                        }
                    }

                }

                for(Integer score : scores) {
                    answer += score;
                }

                return answer;
            }

            private boolean isNum(char c) {
                return c >= '0' && c <='9';
            }

            private boolean isArea(char c) {
                return c == 'S' || c == 'D' || c == 'T';
            }

        }
        new Solution().solution("1D2S3T*");

    }



}
