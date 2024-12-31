package herb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _찍신찾기 {
    public static String solution(String[][] arr) {
        //1번으로 모두 찍은 a, 3번으로 모두 찍은 b, 5번으로 모두 찍은 c
        Map<Integer, Integer> answerMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int answer = Integer.parseInt(arr[i][0].split(" ")[2]);
            int score = Integer.parseInt(arr[i][1].split(" ")[2]);

            //정답 번호별 스코어를 모두 더해준다.
            answerMap.put(answer, answerMap.getOrDefault(answer, 0) + score);
        }

        Applicant[] applicants = new Applicant[3];
        applicants[0] = new Applicant("a", answerMap.getOrDefault(1, 0));
        applicants[1] = new Applicant("b", answerMap.getOrDefault(3, 0));
        applicants[2] = new Applicant("c", answerMap.getOrDefault(5, 0));

        //점수 순으로 정렬
        Arrays.sort(applicants, ((o1, o2) -> o2.score - o1.score));

        StringBuilder answer = new StringBuilder().append(applicants[0]);

        for (int i = 1; i <= 2; i++) {
            if (applicants[0].score == applicants[i].score) {
                answer.append(", ").append(applicants[i]);
            } else {
                break;
            }
        }

        return answer.toString();
    }

   static class Applicant {
        String name;
        int score;

        Applicant(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return name + " : " + score;
        }
    }

    public static void main(String[] args) {
        String[][] input1 = {{ "answer : 1", "score : 5"}, { "answer : 3", "score : 3"}, { "answer : 2", "score : 4"}};
        String[][] input2 = {{ "answer : 1", "score : 5" }, { "answer : 5", "score : 5"}, { "answer : 2", "score : 4"}};
        System.out.println(solution(input2));
    }


}
