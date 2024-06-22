public class _시저암호 {
    class Solution {
        public String solution(String s, int n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                //97 ~ 122
                //122 + 1 = 97
                char c = s.charAt(i);
                if (c == ' ') {
                    sb.append(" ");
                    continue;
                }

                if (c + n > 'z' || (c <= 'Z' && c + n > 'Z')) {
                    sb.append((char)(c + n - 26));
                    continue;
                }

                sb.append((char) (c + n));
            }
            return sb.toString();
        }
    }
}
