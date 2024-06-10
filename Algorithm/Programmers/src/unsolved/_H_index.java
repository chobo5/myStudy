package unsolved;

import java.util.Arrays;

public class _H_index {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] citations) {
                int answer = 0;
                Arrays.sort(citations);
                for (int i = citations.length - 1; i >= 0; i--) {
                    int x = citations[i];
                    if (x > citations.length) {
                        continue;
                    }
                    int count = 0;
                    for (int j = 0; j < citations.length; j++) {
                        if (citations[j] >= x) {
                            count++;
                        }
                    }

                    if (x <= count) {
                        return x;
                    }

                }
                return 0;
            }
        }
    }
}
