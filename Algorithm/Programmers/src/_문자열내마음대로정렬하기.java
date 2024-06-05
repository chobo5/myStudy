import java.util.Arrays;

public class _문자열내마음대로정렬하기 {
    public static void main(String[] args) {
        class Solution {
            public String[] solution(String[] strings, int n) {
                Arrays.sort(strings, ((o1, o2) -> {
                    if (o1.charAt(n) == o2.charAt(n)) {
                        int index = Math.min(o1.length(), o2.length());
                        for (int i = 0; i < index; i++) {
                            if (o1.charAt(i) == o2.charAt(i)) {
                                continue;
                            }
                            return o1.charAt(i) - o2.charAt(i);
                        }
                    }
                    return o1.charAt(n) - o2.charAt(n);
                }));
                return strings;
            }
        }
    }
}
