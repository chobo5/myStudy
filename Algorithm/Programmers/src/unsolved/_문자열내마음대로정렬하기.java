package unsolved;

public class _문자열내마음대로정렬하기 {
    public static void main(String[] args) {
        class Solution {
            public String[] solution(String[] strings, int n) {
                for (int i = 0; i < strings.length; i++) {
                    for (int j = 0; j < strings.length - 1 - i; j++) {
                        char c1 = strings[j].charAt(n);
                        char c2 = strings[j + 1].charAt(n);
                        if (c1 > c2) {
                            String temp = strings[j];
                            strings[j] = strings[j + 1];
                            strings[j + 1] = temp;
                        } else if (c1 == c2) {
                            char c3 = strings[j].charAt(n+1);
                            char c4 = strings[j + 1].charAt(n+1);
                            if (c3 > c4) {
                                String temp = strings[j];
                                strings[j] = strings[j + 1];
                                strings[j + 1] = temp;
                            }
                        }

                    }

                }
                return strings;
            }
        }
    }
}
