import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(in.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());

            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            int[] sides = {a, b ,c};
            Arrays.sort(sides);

            if (sides[2] >= sides[0] + sides[1]) {
                sb.append("Invalid").append("\n");
                continue;
            }

            if (a == b && b == c) {
                sb.append("Equilateral").append("\n");
            } else if (a == b || b == c || a == c) {
                sb.append("Isosceles").append("\n");
            } else if (a != b && b != c && a != c) {
                sb.append("Scalene").append("\n");
            }
        }

        System.out.println(sb);
    }
}
