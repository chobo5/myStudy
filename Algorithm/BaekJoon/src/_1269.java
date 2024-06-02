import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();


        int common = 0;

        st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < a; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < b; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (setA.contains(x)) {
                common++;
            }
        }

        System.out.println(a + b - 2 * common);


    }
}
