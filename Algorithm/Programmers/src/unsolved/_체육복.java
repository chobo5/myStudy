package unsolved;

public class _체육복 {
    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;
            int[] arr = new int[n];

            for (int i = 0; i < lost.length; i++) {
                arr[lost[i] - 1] -= 1;
            }

            for (int i = 0; i < reserve.length; i++) {
                arr[reserve[i] - 1] += 1;
            }

            for (int i = 0; i < n; i++) {
                arr[i] += 1;
                if (arr[i] == 0) {
                    if (i == 0) {
                        if (arr[i] == 0 || arr[i + 1] > 1) {
                            arr[i] += 1;
                            arr[i + 1] -= 1;
                        }
                    } else if (i == n - 1) {
                        if (arr[i] == 0 || arr[i - 1] > 1) {
                            arr[i] += 1;
                            arr[i - 1] -= 1;
                        }
                    } else {
                        if (arr[i] == 0) {
                            if (arr[i + 1] > 1) {
                                arr[i] += 1;
                                arr[i + 1] -= 1;
                            } else if (arr[i - 1] > 1) {
                                arr[i] += 1;
                                arr[i - 1] -= 1;
                            }
                        }

                    }
                }
                if (arr[i] > 0) answer++;
            }
            return answer;
        }
    }
}
