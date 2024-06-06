
import java.util.HashMap;
import java.util.Map;

public class _달리기경주 {
    public static void main(String[] args) {
        class Solution {
            public static String[] solution(String[] players, String[] callings) {
                Map<String, Integer> playersMap = new HashMap<>();
                for (int i = 0; i < players.length; i++) {
                    playersMap.put(players[i], i);
                }

                for (int i = 0; i < callings.length; i++) {
                    String call = callings[i];
                    int rank = playersMap.get(call);
                    String frontPlayer = players[rank - 1];

                    players[rank - 1] = call;
                    players[rank] = frontPlayer;

                    playersMap.put(call, rank - 1);
                    playersMap.put(frontPlayer, rank);
                }

                return players;
            }
        }
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println(Solution.solution(players, callings));

    }
}
