package unsolved;

import java.util.*;

public class _겹치는선분의길이 {
    public static void main(String[] args) {
        class Solution {
            public static int solution(int[][] lines) {
                List<Integer> list = new ArrayList<>();
                Set<Integer> set = new HashSet<>();
                int count = 0;
                for (int i = 0; i < lines.length; i++) {
                    for (int j = lines[i][0]; j <=lines[i][1] ; j++) {
                        list.add(j);
                    }
                }

                list.sort(((o1, o2) -> o1 - o2));

                for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i) == list.get(i + 1)) {
                        set.add(i);
                    }
                }

                Integer[] arr = set.toArray(new Integer[0]);
                Arrays.sort(arr);

                for (int i = 0; i < arr.length - 1; i++) {
                    if (arr[i] == arr[i + 1]) {
                        count++;
                    }
                }

                return count;
            }
        }
        int[][] lines = {{0, 1}, {2, 5}, {3, 9}};
        System.out.println(Solution.solution(lines));
    }
}
