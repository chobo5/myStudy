package unsolved;

import java.util.HashMap;
import java.util.Map;

public class _실패율 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int N, int[] stages) {
                int[] answer = {};
                Map<Double, Integer> map = new HashMap<>();
                for (int i = 1; i <= N; i++) {
                    int up = 0;
                    int down = 0;
                    for (int j = 0; j <= stages.length; j++) {
                        if (i == stages[j]) up++;
                        if (i <= stages[j]) down++;
                    }
                    map.put(Double.valueOf(up/down), i);
                }


                return answer;
            }
        }
    }
}
