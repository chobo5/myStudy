import java.util.ArrayList;
import java.util.List;

public class _1차캐시 {
    class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;

            if (cacheSize == 0) {
                return cities.length * 5;
            }

            List<String> cache = new ArrayList<>();
            for (String city : cities) {
                String cityLower = city.toLowerCase();
                if (cache.contains(cityLower)) {
                    cache.remove(cityLower);
                    cache.add(cityLower);
                    answer += 1;
                } else {
                    if (cache.size() == cacheSize) {
                        cache.remove(0);
                    }
                    cache.add(cityLower);
                    answer += 5;
                }
            }
            return answer;
        }
    }
}
