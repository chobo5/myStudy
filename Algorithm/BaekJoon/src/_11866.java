import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(str, " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        sb.append("<");
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n + 1 ; i++) {
            queue.offer(i);
        }


        while (queue.size() != 0) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            if (queue.size() == 1) {
                sb.append(queue.poll()).append(">");
            }else {
                sb.append(queue.poll()).append(", ");
            }

        }

        System.out.println(sb);

    }
}
