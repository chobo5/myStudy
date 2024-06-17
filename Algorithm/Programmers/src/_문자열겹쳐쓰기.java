public class _문자열겹쳐쓰기 {
    public static void main(String[] args) {
        class Solution {
            public String solution(String my_string, String overwrite_string, int s) {
                String before = my_string.substring(0, s);
                String after = my_string.substring(s + overwrite_string.length());
                // 세 부분을 합쳐서 새로운 문자열 생성
                return before + overwrite_string + after;
            }
        }
    }
}
