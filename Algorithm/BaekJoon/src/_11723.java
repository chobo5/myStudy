import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            list.add(0);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            String command = st.nextToken();
            if (command.equals("all")) {
                for (int j = 0; j <= 20; j++) {
                    list.set(j, j);
                }
            } else if (command.equals("empty")) {
                for (int j = 0; j <= 20; j++) {
                    list.set(j, 0);
                }
            } else {
                int x = Integer.parseInt(st.nextToken());
                if (command.equals("add")) {
                    list.set(x, x);
                } else if (command.equals("remove")) {
                    list.set(x, 0);
                } else if (command.equals("check")) {
                    if(list.get(x) == x) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                } else {
                    if (list.get(x) == x) {
                        list.set(x, 0);
                    } else {
                        list.set(x, x);
                    }
                }
            }

        }
        System.out.println(sb);
    }


}
