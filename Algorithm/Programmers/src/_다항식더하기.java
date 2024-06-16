import java.util.List;

public class _다항식더하기 {
    public static void main(String[] args) {
        class Solution {
            public static String solution(String polynomial) {
                String[] poly = polynomial.split(" ");
                int x = 0;
                int constant = 0;
                for (int i = 0; i < poly.length; i++) {
                    if (poly[i].contains("x")) {
                        if (poly[i].equals("x")) {
                            x += 1;
                            continue;
                        }
                        x += Integer.parseInt(poly[i].replaceAll("x", ""));
                    } else if (!poly[i].equals("+")) {
                        constant += Integer.parseInt(poly[i]);
                    }
                }
                if (x == 0) {
                    return String.valueOf(constant);
                }
                String xNum = x == 1 ? "" : String.valueOf(x);
                if (constant == 0) {
                    return xNum + "x";
                }

                String answer = xNum + "x" + " + " + String.valueOf(constant);
                return answer;
            }
        }
        System.out.println(Solution.solution("x + x + x"));
    }
}
