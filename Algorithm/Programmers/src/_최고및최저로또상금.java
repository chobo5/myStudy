import java.util.ArrayList;
import java.util.List;

public class _최고및최저로또상금 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int[] lottos, int[] win_nums) {
                List<Integer> wins = new ArrayList<>();
                for (int num : win_nums) {
                    wins.add(num);
                }
                int high = 0;
                int low = 0;
                for (int i = 0; i < lottos.length; i++) {
                    if (lottos[i] == 0) {
                        high ++;
                    } else if (wins.contains(lottos[i])) {
                        high ++;
                        low ++;
                    }
                }
                int[] answer = {makeTier(high), makeTier(low)};
                return answer;
            }

            public int makeTier(int n) {
                int tier = 7 - n;
                if (tier > 5) {
                    return 6;
                } else {
                    return tier;
                }
            }
        }
    }
}
