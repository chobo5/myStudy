package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18258 {
    static int position = 0;
    static int top = 0;
    static int[] queue = new int[2000001];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            switch (st.nextToken()) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    push(x);
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(isEmpty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }

        }
        br.close();

        System.out.println(sb);

    }

    static void push(int num) {
        queue[position] = num;
        position++;
    }

    static int pop() {
        if (position > top) {
            int num = queue[top];
            top++;
            return num;
        }

        return -1;

    }

    static int size() {
        return position - top;
    }

    static int isEmpty() {
        if (position > top) {
            return 0;
        }
        return 1;
    }

    static int front() {
        if (position == top) {
            return -1;
        }
        return queue[top];

    }

    static int back() {
        if (position == top) {
            return -1;
        }
        return queue[position - 1 - top];

    }
}