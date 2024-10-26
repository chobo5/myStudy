package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> sticks = new Stack<>();
        sticks.add(64);
        int sum = 64;

        int x = Integer.parseInt(in.readLine());

        while (sum > x) {

            int shortest = sticks.pop();
            int divided = shortest / 2;

            if (sum - divided >= x) {
                sticks.add(divided);
                sum -= divided;
            } else {
                sticks.add(divided);
                sticks.add(divided);
            }

        }
        System.out.println(sticks.size());

    }
}