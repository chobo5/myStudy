import java.util.Arrays;

public class _배열조각하기 {
    class Solution {
        public static int[] solution(int[] arr, int[] query) {
            for (int i = 0; i < query.length; i++) {
                arr = work(arr, query[i], i);
            }
            return arr;
        }

        public static int[] work(int[] arr, int queryIndex, int index) {
            if (index % 2 == 0) {
                return Arrays.copyOfRange(arr, 0, queryIndex + 1);
            } else {
                return Arrays.copyOfRange(arr, queryIndex, arr.length);
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5};
        int[] query = {4, 1, 2};
        Solution.solution(arr, query);
    }
}
