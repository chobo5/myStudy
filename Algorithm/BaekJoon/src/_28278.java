import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();


        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int input = Integer.parseInt(st.nextToken());
            switch (input) {
                case 1:
                    int nextInput = Integer.parseInt(st.nextToken());
                    stack.push(nextInput);
                    break;
                case 2:
                    if (stack.empty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(stack.pop()).append("\n");
                    }
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
                    break;
                case 4:
                    if (stack.empty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case 5:
                    if (stack.empty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(stack.lastElement()).append("\n");
                    }
                    break;
            }
        }
        br.close();
        System.out.println(sb);
    }
}
