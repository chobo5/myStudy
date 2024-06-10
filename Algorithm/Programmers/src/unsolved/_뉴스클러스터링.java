package unsolved;

import java.util.ArrayList;
import java.util.List;

public class _뉴스클러스터링 {
    public static void main(String[] args) {
        class Solution {
            public static int solution(String str1, String str2) {
                int answer = 0;
                List<String> str1List = new ArrayList<>();
                List<String> str2List = new ArrayList<>();
                str1List = getStrList(str1, str1List);
                str2List = getStrList(str2, str2List);

                int same = 0;

                if (str1List.size() == 0 && str2List.size() == 0) {
                    return 65536;
                }

                for (int i = 0; i < str1List.size(); i++) {
                    String e = str1List.get(i);
                    for (int j = 0; j < str2List.size(); j++) {
                        if (e.equals(str2List.get(j))) {
                            same++;
                            break;
                        }
                    }
                }


                double j = (double) same / (str1List.size() + str2List.size() - same);

                return (int) Math.floor(j * 65536);
            }

            public static List<String> getStrList(String str, List<String> list) {
                for (int i = 0; i < str.length() - 1; i++) {
                    char first = Character.toUpperCase(str.charAt(i));
                    char second = Character.toUpperCase(str.charAt(i + 1));

                    if (!validate(first) || !validate(second)) {
                        continue;
                    }

                    list.add(String.valueOf(first) + String.valueOf(second));
                }
                return  list;
            }

            public static boolean validate(char c) {
                if (c > 90 || c < 65) {
                    return false;
                }
                return true;
            }
        }

        System.out.println(Solution.solution("aa1+aa2", "AAAA12"));
    }
}
