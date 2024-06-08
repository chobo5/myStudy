import java.util.*;

public class _연속부분수열합의개수 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] elements) {
                Set<Integer> hashSet = new HashSet<>();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < 2; i++) {
                    for (int e : elements) {
                        list.add(e);
                    }
                }

                for (int i = 0; i < elements.length; i++) {
                    for (int j = 1; j <= elements.length; j++) {
                        List<Integer> temp = list.subList(i, i + j);
                        int sum = 0;
                        for (int n : temp) {
                            sum += n;
                        }
                        hashSet.add(sum);
                    }
                }
                return hashSet.size();
            }
        }
    }
}
