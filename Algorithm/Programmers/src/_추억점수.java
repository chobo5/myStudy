import java.util.HashMap;
import java.util.Map;

public class _추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> nameAndScore = new HashMap<>();

        for (int i = 0; i < yearning.length; i++) {
            nameAndScore.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            String[] people = photo[i];
            for (int j = 0; j < people.length; j++) {
                String strName = people[j];
                if (nameAndScore.containsKey(strName)) {
                    int score = nameAndScore.get(strName);
                    sum += score;
                }
            }
            answer[i] = sum;
        }

        return answer;
    }
}
