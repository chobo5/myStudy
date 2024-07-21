import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        int count = 0;
        while (n != 1) {
            int start = n % 2 == 0 ? n - 1 : n - 2;
            for (int i = start; i >= 0; i -= 2) {
                int x = list.get(i);
                int y = list.get(i - 1);
                if ((x == kim && y == lim) || (x == lim && y == kim)) {
                    System.out.println(count + 1);
                    return;
                }

                if (x == kim || x == lim) {
                    list.remove(i - 1);
                } else if (y == kim || y == lim) {
                    list.remove(i);
                } else {
                    list.remove(i);
                }
            }
            count++;
            n = n % 2 == 0 ? n / 2 : (n / 2) + 1;
        }
        System.out.println(-1);

    }
}
