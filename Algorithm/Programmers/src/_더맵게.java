import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _더맵게 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] scoville, int K) {
                int answer = 0;
                Arrays.sort(scoville);
                Queue<Integer> queue = new LinkedList<>();
                for (int i = 0; i < scoville.length - 1; i++) {
                    int first = scoville[i];
                    int second = scoville[i + 1];
                    int mixed = first + (second * 2);

                }

                return answer;
            }
        }
    }
}
