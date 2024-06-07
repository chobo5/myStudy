package unsolved;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class _체육복 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int n, int[] lost, int[] reserve) {
                int answer = n - lost.length;

                for (int i = 0; i < lost.length; i++) {
                    for (int j = 0; j < reserve.length; j++) {
                        if (lost[i] == reserve[j]) {
                            reserve[j] = 0;
                            lost[i] = 0;
                            answer++;
                            break;
                        }
                    }
                }

                for (int i = 0; i < lost.length; i++) {
                    if (lost[i] == 0) {
                        continue;
                    }
                    for (int j = 0; j < reserve.length; j++) {
                        if (reserve[j] == 0) {
                            continue;
                        }
                        if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                            reserve[j]  = 0;
                            answer++;
                            break;
                        }
                    }
                }



                return answer;
            }
        }
    }
}
