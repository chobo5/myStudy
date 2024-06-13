package unsolved;

import java.util.Arrays;

public class _주사위게임3 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int a, int b, int c, int d) {
                int[] arr = {a, b, c, d};

                Arrays.sort(arr);

                if (arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3]) { //모두 같음
                    return 1111 * arr[0];
                }

                if (arr[0] == arr[1] && arr[2] == arr[3]) { // 2 , 2
                    int p  = arr[1];
                    int q = arr[0] == p ? arr[3] : arr[0];
                    return (p + q) * Math.abs(p - q);
                }

                if (arr[0] != arr[3] && arr[1] == arr[2]) { // 3, 1 or 1, 3
                    int p = arr[0] == arr[1] ? arr[0] : arr[3];
                    int q = arr[0] == p ? arr[3] : arr[0];
                    return (10 * p + q) * (10 * p + q);
                }

                if (arr[0] == arr[1] || arr[1] == arr[2] || arr[2] == arr[3]) {
                    if (arr[0] == arr[1]) {
                        return arr[2] * arr[3];
                    }

                    if (arr[1] == arr[2]) {
                        return arr[0] * arr[3];
                    }
                    return arr[0] * arr[1];
                }

                return arr[0];

            }
        }
    }
}
