package unsolved;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _주사위게임3 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int a, int b, int c, int d) {
                int[] arr = {a, b, c, d};
                Map<Integer, Integer> hashMap = new HashMap<>();
                for (int i = 0; i < arr.length; i++) {
                    hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
                }

                if (hashMap.size() == 1) {

                }

                if (hashMap.size() == 2) {

                }

                if (hashMap.size() == 3) {

                }

                if (hashMap.size() == 4) {

                }





                return arr[0];

            }
        }
    }
}
