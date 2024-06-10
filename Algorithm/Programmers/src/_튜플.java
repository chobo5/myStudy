import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _튜플 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(String s) {

                String[] strArr = s.replace("{{", "").replace("}}", "").replace("},{", "-").split("-");
                List<Integer> list = new ArrayList<>();

                Arrays.sort(strArr, ((o1, o2) -> o1.length() - o2.length()));
                for (int i = 0; i < strArr.length; i++) {
                    String[] temp = strArr[i].split(",");
                    for (String t : temp) {
                        int n = Integer.parseInt(t);
                        if (!list.contains(n)) {
                            list.add(n);
                        }
                    }
                }

                int[] answer = new int[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    answer[i] = list.get(i);
                }


                return answer;
            }
        }
    }
}
