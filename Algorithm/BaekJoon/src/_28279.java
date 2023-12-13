import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class _28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> linkedList = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            switch (x) {
                case 1:
                    int a = Integer.parseInt(st.nextToken());
                    linkedList.addFirst(a);
                    break;
                case 2:
                    int b = Integer.parseInt(st.nextToken());
                    linkedList.addLast(b);
                    break;
                case 3:
                    if (!linkedList.isEmpty()) {
                        sb.append(linkedList.removeFirst()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case 4:
                    if (!linkedList.isEmpty()) {
                        sb.append(linkedList.removeLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case 5:
                    sb.append(linkedList.size()).append("\n");
                    break;
                case 6:
                    if (linkedList.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case 7:
                    if (linkedList.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(linkedList.getFirst()).append("\n");
                    }
                    break;
                case 8:
                    if (linkedList.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(linkedList.getLast()).append("\n");
                    }
                    break;
            }

        }
        System.out.println(sb);

    }
}