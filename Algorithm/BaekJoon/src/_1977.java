import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _1977 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(in.readLine());
        int n = Integer.parseInt(in.readLine());
        in.close();
        List<Integer> list = new ArrayList<>();
        int x = 1;
        while (true) {
            int pow = (int) Math.pow(x, 2);
            if (pow > n) {
                break;
            }

            if (pow >= m) {
                list.add(x * x);
            }

            x++;
        }
        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            int answer = 0;
            for (int a : list) {
                answer += a;
            }
            System.out.println(answer);
            System.out.println(list.get(0));
        }
    }
}
