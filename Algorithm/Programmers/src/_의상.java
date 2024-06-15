import java.util.HashMap;
import java.util.Map;

public class _의상 {
    public static void main(String[] args) {
        class Solution {
            public int solution(String[][] clothes) {
                int answer = 1;
                Map<String, Integer> hashMap = new HashMap<>();
                for (int i = 0; i < clothes.length; i++) {
                    String[] peice = clothes[i];
                    hashMap.put(peice[1], hashMap.getOrDefault(peice[1], 0) + 1);
                }

                for (String key : hashMap.keySet()) {
                    answer *= (hashMap.get(key) + 1);
                }

                answer -= 1;

                return answer;
            }
        }
    }
}
