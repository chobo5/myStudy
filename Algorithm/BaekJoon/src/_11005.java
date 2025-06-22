import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int system = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        while (num >= system) {
            stack.push(num % system);
            num /= system;
        }
        stack.push(num);

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            if (pop >= 10) {
                sb.append(Character.toString(pop + 55));
            } else {
                sb.append(pop);
            }

        }

        System.out.println(sb);


    }
}
