

public class _숫자짝궁 {
    public static void main(String[] args) {
        class Solution {
            public String solution(String X, String Y) {
                StringBuilder sb = new StringBuilder();
                int[] x = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                int[] y = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                for (int i = 0; i < X.length(); i++) {
                    x[X.charAt(i) - 48] += 1;
                }
                for (int i = 0; i < Y.length(); i++) {
                    y[Y.charAt(i) - 48] += 1;
                }
                for (int i = 9; i >= 0; i--) {
                    for (int j = 0; j < Math.min(x[i], y[i]); j++) {
                        sb.append(i);
                    }
                }
                if("".equals(sb.toString())){
                    return "-1";
                }else if(sb.toString().charAt(0)==48){
                    return "0";
                }else {
                    return sb.toString();
                }

            }
        }

        System.out.println(new Solution().solution("5525", "1255"));
    }
}
