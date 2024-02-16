import java.util.Stack;

public class _신규아이디추천 {
    public static void main(String[] args) {
        class Solution {
            public String solution(String new_id) {
                String answer = "";
                //1단계
                answer = new_id.toLowerCase();
                //2,3,4단계
                Stack<Character> step23 = new Stack<>();
                for (int i = 0; i < answer.length(); i++) {
                    char c = answer.charAt(i);
                    //2단게 원하는 문자만
                    if (c == '-' || c == '_' || c == '.' || (c >= 97 && c <= 122) || (c >= 48 && c <= 57)) {
                        //3단계 연속된 점 제거
                        if (!step23.empty() &&i > 0 && c == '.' && step23.peek() == '.') {
                            continue;
                        } else {
                            step23.push(c);
                        }
                    }
                }

                //4단계 양쪽 끝 점 제거
                Object[] temp = step23.toArray();
                StringBuilder step4 = new StringBuilder();
                for (int i = 0; i < temp.length; i++) {
                    if (i == 0 || i == temp.length - 1) {
                        if ((char) temp[i] == '.') {
                            continue;
                        }
                    }
                    step4.append((char) temp[i]);
                }

                //5단계
                if (step4.length() == 0) {
                    step4.append("a");
                }

                //6단계
                if (step4.length() >= 16) {
                    step4 = step4.delete(15, step4.length());
                    if (step4.charAt(14) == '.') {
                        step4.deleteCharAt(14);
                    }
                }



                if (step4.length() <= 2) {
                    int lastIndex = step4.length() - 1;
                    while (true) {
                        if (step4.length() == 3) break;
                        step4.append(step4.charAt(lastIndex));
                    }
                }

                return step4.toString();
            }
        }

        System.out.println(new Solution().solution("=.="));

    }
}
