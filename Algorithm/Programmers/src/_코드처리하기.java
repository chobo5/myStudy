public class _코드처리하기 {
    class Solution {
        public String solution(String code) {
            int mode = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < code.length(); i++) {
                char c = code.charAt(i);
                if (c == '1') {
                    mode = mode == 1 ? 0 : 1;
                    continue;
                }
                if (mode == 0) {
                    if (i % 2 == 0) {
                        sb.append(c);
                    }
                } else {
                    if (i % 2 == 1) {
                        sb.append(c);
                    }
                }
            }
            return sb.length() == 0 ? "EMPTY" : sb.toString();
        }
    }
}
