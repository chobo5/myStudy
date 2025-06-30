import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] moves = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        for (int i = 0; i < n; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
            deque.add(i);
        }

        int balloon = 0;
        int move = moves[0];
        StringBuilder sb = new StringBuilder();
        sb.append(balloon + 1).append(" ");

        while (!deque.isEmpty()) {
            if (move > 0) {
                for (int i = 0; i < move % deque.size(); i++) {
                    deque.addLast(deque.pollFirst());
                }
                balloon = deque.pollFirst();

            } else {
                for (int i = 0; i < Math.abs(move) % deque.size() ; i++) {
                    deque.addFirst(deque.pollLast());
                }
                balloon = deque.pollLast();
            }
            move = moves[balloon];
            sb.append(balloon + 1).append(" ");
        }

        System.out.println(sb);

    }
}