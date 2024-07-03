import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        Map<String, Integer> games = new HashMap<>();
        games.put("Y", 1);
        games.put("F", 2);
        games.put("O", 3);

        Set<String> played = new HashSet<>();

        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int answer = 0;
        int count = 0;
        int nop = games.get(game);
        for (int i = 0; i < n; i++) {
            String player = in.readLine();
            if (played.contains(player)) {
                continue;
            } else {
                count++;
                played.add(player);
            }

            if (count == nop) {
                count = 0;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
