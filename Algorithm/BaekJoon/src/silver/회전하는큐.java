package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 회전하는큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Integer> deque = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        int answer = 0;
        st = new StringTokenizer(in.readLine());

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int index = deque.indexOf(target);
            int half = deque.size() % 2 == 0 ? deque.size() / 2 - 1 : deque.size() / 2;
            if (index <= half ) {
                for (int j = 0; j < index; j++) {
                    moveLeft(deque);
                    answer++;
                }
                deque.pollFirst();
            } else {
                for (int j = 0; j < deque.size() - index; j++) {
                    moveRight(deque);
                    answer++;
                }
                deque.pollFirst();
            }
        }

        in.close();
        System.out.println(answer);
    }

    private static void moveLeft(LinkedList<Integer> deque) {
        deque.add(deque.pollFirst());
    }

    private static void moveRight(LinkedList<Integer> deque) {
        deque.addFirst(deque.pollLast());
    }
}
