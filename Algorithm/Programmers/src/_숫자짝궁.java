import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _숫자짝궁 {
    public static void main(String[] args) {
        class Solution {
            public String solution(String X, String Y) {
                StringBuilder sb = new StringBuilder();
                List<String> common = new ArrayList<>();
                String[] arrY = Y.split("");
                for (int i = 0; i < X.length(); i++) {
                    if (Arrays.asList(arrY).contains(X.charAt(i))) {
                        common.add(String.valueOf(X.charAt(i)));
                    }
                }
                 common.stream().sorted().forEach(sb::append);
                String answer = sb.toString().length() == 0 ? "-1" : sb.toString();
                if (Integer.parseInt(answer) == 0) return "0";
                return answer;
            }
        }
    }
}
