package unsolved;

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
        StringBuilder sb = new StringBuilder();
        Deque<Baloon> deque = new ArrayDeque<>();
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        br.close();

        for (int i = 1; i <= n ; i++) {
            int x = Integer.parseInt(st.nextToken());
            deque.add(new Baloon(i, x));
        }

        Baloon deleted = deque.pollFirst();
        sb.append(deleted.key).append(" ");
        int move = deleted.move;

        while (deque.size() != 1) {
            if (move > 0) {
               int minMove = move % deque.size();
                System.out.println("minMovew " + minMove);
                if (minMove != 0) {
                    for (int i = 0; i < move - 1; i++) {
                        deque.addLast(deque.pollFirst());
                    }
                }
                deleted = deque.pollFirst();
                sb.append(deleted.key).append(" ");
                move = deleted.move;
            } else {

                int minMove = Math.abs(move) % deque.size();
                System.out.println("minMovew " + minMove);
                if (minMove != 0) {
                    for (int i = 0; i < move - 1; i++) {
                        deque.addFirst(deque.pollLast());
                    }
                }
                deleted = deque.pollLast();
                sb.append(deleted.key).append(" ");
                move = deleted.move;
            }
        }

        sb.append(deque.pollFirst().key);

        System.out.println(sb);



    }

    static class Baloon {
        int key;
        int move;

        Baloon(int order, int value) {
            this.key = order;
            this.move = value;
        }
    }
}
