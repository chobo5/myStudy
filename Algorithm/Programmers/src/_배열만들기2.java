import java.util.ArrayList;
import java.util.List;

public class _배열만들기2 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int l, int r) {
                List<Integer> list = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    if (i % 5 == 0) {
                        String str = String.valueOf(i);
                        boolean flag = true;
                        for (int j = 0; j < str.length(); j++) {
                            if (str.charAt(j) != '0' && str.charAt(j) != '5') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            list.add(i);
                        }
                    }
                }
                if (list.size() == 0) {
                    int[] answer = {-1};
                    return answer;
                }
                int[] answer = new int[list.size()];
                for (int i = 0; i < answer.length; i++) {
                    answer[i] = list.get(i);
                }
                return answer;
            }
        }
    }
}
