import java.util.HashMap;
import java.util.Map;

public class _전화번호목록 {
    public static void main(String[] args) {
        class Solution {
            public static boolean solution(String[] phone_book) {
                boolean answer = true;
                Map<String, Integer> hashMap = new HashMap<>();
                for (int i = 0; i < phone_book.length; i++) {
                    hashMap.put(phone_book[i], i);
                }

                for (int i = 0; i < phone_book.length; i++) {
                    for (int j = 0; j < phone_book[i].length(); j++) {
                        String temp = phone_book[i].substring(0, j);
                        System.out.println(temp);
                        if (hashMap.containsKey(temp)) {
                            return false;
                        }
                    }
                }
                return answer;
            }
        }
        String[] a = {"119", "97674223", "1195524421"};

        Solution.solution(a);
    }
}
