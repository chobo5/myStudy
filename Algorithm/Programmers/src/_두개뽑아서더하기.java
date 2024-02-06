import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _두개뽑아서더하기 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int[] numbers) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < numbers.length - 1; i++) {
                    int a = numbers[i];
                    for (int j = i + 1; j < numbers.length ; j++) {
                        int b = numbers[j];
                        if (!list.contains(a + b)) {
                            list.add(a + b);
                        }
                    }
                }
                int[] answer = list.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
                Arrays.sort(answer);
                return answer;

            }
        }
    }
}
