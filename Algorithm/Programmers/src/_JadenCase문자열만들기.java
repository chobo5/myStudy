public class _JadenCase문자열만들기 {
    public static void main(String[] args) {
        class Solution {
            public String solution(String s) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (i == 0) {
                        if (c >= 97 && c <= 122) {
                            sb.append((char)(c - 32));
                        } else {
                            sb.append(c);
                        }
                    } else {
                        if (s.charAt(i - 1) == 32 && c >= 97 && c <= 122) {
                            sb.append((char)(c - 32));
                        } else if (s.charAt(i - 1) != 32 && c >= 65 && c <= 90){
                            sb.append((char)(c + 32));
                        } else {
                            sb.append(c);
                        }
                    }

                }
                return sb.toString();
            }
        }

        Solution solution = new Solution();
        System.out.println(solution.solution("3people unFollowed me"));
    }
}
