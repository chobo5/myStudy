import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _개인정보수집유효기간 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(String today, String[] terms, String[] privacies) {
                List<Integer> result = new ArrayList<>();

                Map<String, Integer> type = new HashMap<>();

                LocalDate todayDate = getLocalDate(today);

                for (String term : terms) {
                    String[] split = term.split(" ");
                    type.put(split[0], Integer.parseInt(split[1]));
                }

                for (int i = 0; i < privacies.length; i++) {
                    String[] split = privacies[i].split(" ");
                    long month = type.get(split[1]);
                    LocalDate validateDate = getLocalDate(split[0]).plusMonths(month);

                    if (todayDate.isAfter(validateDate) || todayDate.isEqual(validateDate)) {
                        result.add(i + 1);
                    }
                }

                return result.stream().mapToInt(Integer::intValue).toArray();
            }

            private LocalDate getLocalDate(String date) {
                String[] split = date.split("\\.");
                return LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));

            }
        }
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        new Solution().solution("2022.05.19", terms, privacies);
    }
}
