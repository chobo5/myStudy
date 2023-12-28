import java.util.ArrayList;
import java.util.List;

public class _크기가작은부분문자열 {
    public int solution(String t, String p) {
        int answer = 0;
        long longP = Long.parseLong(p);

        for (int i = 0; i < t.length()- (p.length() - 1); i++) {
            String sub = t.substring(i, i + p.length());
            long n = Long.parseLong(sub);
            if (n <= longP) {
                answer++;
            }
        }

        return answer;
    }
}
