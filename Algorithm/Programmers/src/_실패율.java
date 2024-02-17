import java.util.*;

public class _실패율 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int N, int[] stages) {
                int[] answer = new int[N];
                Map<Integer, Double> map = new HashMap<>();
                for (int i = 1; i <= N; i++) {
                    double up = 0.0;
                    double down = 0.0;
                    for (int j = 0; j < stages.length; j++) {
                        if (stages[j] >= i) {
                            down++;
                        }
                        if (stages[j] == i) {
                            up++;
                        }
                    }
                    if (down == 0) {
                        map.put(i, 0.0);
                    } else {
                        map.put(i, (up / down));
                    }
                }
                List<Integer> list = new ArrayList<>(map.keySet());
                Collections.sort(list, (o1, o2) -> Double.compare(map.get(o2), map.get(o1)));

                return list.stream().mapToInt(Integer::intValue).toArray();
            }
        }
    }
}
