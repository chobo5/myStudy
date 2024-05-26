import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        in.close();
        Queue<Integer> deck = new LinkedList<>();
        List<Integer> trash = new ArrayList<>();

        for (int i = 0; i < n ; i++) {
            deck.add(i + 1);
        }

        while (deck.size() > 1) {
            trash.add(deck.poll());
            deck.add(deck.poll());
        }

        trash.forEach((item) -> {
            System.out.print(item + " ");
        });

        System.out.print(deck.peek());




    }
}
