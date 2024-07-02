import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _3차압축 {
    class Solution {
        public int[] solution(String msg) {
            List<Integer> answer = new ArrayList<>();

            Map<String, Integer> dic = new HashMap<>();
            for (int i = 1; i <= 26; i++) {
                dic.put(String.valueOf((char) ('A' + i)),i);
            }
            int index = 27;

            for (int i = 0; i < msg.length(); i++) {
                char c = msg.charAt(i);
                if (dic.get(String.valueOf(c)) != 0) {
                    String str = String.valueOf(c);
                    answer.add(dic.get(str));
                    dic.put(str, 0);
                } else { // dic.get = 0
                    String subString = "";
                    for (int j = i + 1; j <= msg.length(); j++) {
                        String sub = msg.substring(i, j);
                        if (!dic.containsKey(subString)) {
                            subString = sub;
                            i = j;
                            break;
                        }
                    }

                }
            }

            return answer;
        }

        String getW(int start, String msg, Map<String, Integer> dic) {

            return msg.substring(start);
        }
    }
}
