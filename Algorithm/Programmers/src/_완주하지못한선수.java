import java.util.HashMap;
import java.util.Map;

public class _완주하지못한선수 {
    public static void main(String[] args) {
        class Solution {
            public String solution(String[] participant, String[] completion) {
                String answer = "";
                Map<String, Integer> hashMap = new HashMap<>();
                for (int i = 0; i < participant.length; i++) {
                    String p = participant[i];
                    if (hashMap.get(p) == null) {
                        hashMap.put(p, 1);
                        continue;
                    }
                    hashMap.put(p, hashMap.get(p) + 1);
                }

                for (int i = 0; i < completion.length; i++) {
                    String c = completion[i];
                    if (hashMap.get(c) == null) {
                        return c;
                    }

                    if (hashMap.get(c) > 1) {
                        hashMap.put(c, hashMap.get(c) - 1);
                        continue;
                    }
                    hashMap.remove(c);
                }

                return (String) hashMap.keySet().toArray()[0];
            }
        }
    }
}
