public class _둘만의암호 {
    public static void main(String[] args) {
        class Solution {
            public String solution(String s, String skip, int index) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    for (int j = 0; j < index; j++) {
                        c += 1;
                        if (c > 'z') {
                            c -= 26;
                        }
                        if (skip.contains(String.valueOf(c))) {
                            j--;
                        }
                    }
                    sb.append(String.valueOf(c));

                }
                return sb.toString();
            }
        }
    }
}
