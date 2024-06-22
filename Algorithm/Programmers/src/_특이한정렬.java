import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _특이한정렬 {
    class Solution {
        public int[] solution(int[] numlist, int n) {
            int[] answer = new int[numlist.length];
            Integer[] temp = new Integer[numlist.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = numlist[i];
            }

            Arrays.sort(temp, ((o1, o2) -> {
                int absO1 = Math.abs(o1 - n);
                int absO2 = Math.abs(o2 - n);
                if (absO1 == absO2) {
                    return o2 - o1;
                } else {
                    return absO1 - absO2;
                }
            }));

            for (int i = 0; i < answer.length; i++) {
                answer[i] = temp[i];
            }

            return answer;
        }
    }
}
