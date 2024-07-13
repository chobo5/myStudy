import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class _1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        in.close();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cursor = 0;
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(i + 1);
        }

        while (!linkedList.isEmpty()) {
            int index = (cursor + k - 1) % linkedList.size();
            cursor = index;
            if (linkedList.size() == 1) {
                sb.append(linkedList.remove(index)).append(">");
            } else {
                sb.append(linkedList.remove(index)).append(", ");
            }
        }

        System.out.println(sb);


        /*
        v
        1 2 3 4 5 6 7

        3 6

        cursor: 2
         */
    }
}
