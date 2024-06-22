import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class _문자열밀기 {
    class Solution {
        public int solution(String A, String B) {
            if (A.equals(B)) {
                return 0;
            }
            Deque<Character> deque = new ArrayDeque<>();
            for (int i = 0; i < A.length(); i++) {
                deque.add(A.charAt(i));
            }

            for (int i = 1; i < A.length(); i++) {
                deque.addFirst(deque.pollLast());
                Iterator<Character> iterator = deque.iterator();
                String str = "";
                while (iterator.hasNext()) {
                    str += iterator.next();
                }
                if (str.equals(B)) {
                    return i;
                }
            }

            return -1;
        }
    }
}
