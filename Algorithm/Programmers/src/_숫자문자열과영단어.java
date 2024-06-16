import java.util.HashMap;
import java.util.Map;

public class _숫자문자열과영단어 {
    public static void main(String[] args) {
        class Solution {
            public static int solution(String s) {
                int answer = 0;
                String a = s.replaceAll("zero", "0");
                String b = a.replaceAll("one", "1");
                String c = b.replaceAll("two", "2");
                String d = c.replaceAll("three", "3");
                String e = d.replaceAll("four", "4");
                String f = e.replaceAll("five", "5");
                String g = f.replaceAll("six", "6");
                String h = g.replaceAll("seven", "7");
                String i = h.replaceAll("eight", "8");
                String j = i.replaceAll("nine", "9");
                return Integer.parseInt(j);
            }
        }
        System.out.println(Solution.solution("one4seveneight"));
    }
}
