package unsolved;

import java.util.Arrays;

public class _피로도 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int k, int[][] dungeons) {
                int answer = -1;
                Arrays.sort(dungeons, ((o1, o2) -> {
                    if (o1[0] == o2[0]) {
                        return o1[1]  - o2[1];
                    }
                    return o2[0] - o1[0];
                }));

                return answer;
            }
        }
    }
}
