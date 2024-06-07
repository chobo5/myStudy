import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _신고결과받기 {
    public static void main(String[] args) {
        class Solution {
            public static int[] solution(String[] id_list, String[] report, int k) {
                int[] answer = new int[id_list.length];
                StringTokenizer st;

                Map<String, String> reportMap = new HashMap<>();

                Map<String, Integer> mailMap = new HashMap<>();

                for (int i = 0; i < report.length; i++) {
                    st = new StringTokenizer(report[i], " ");
                    String reporter = st.nextToken();
                    String target = st.nextToken();

                    if (!reportMap.getOrDefault(target, "").contains(reporter)) {
                        if (reportMap.get(target) == null) {
                            reportMap.put(target, reporter);
                        } else {
                            reportMap.put(target, reportMap.get(target) + " " + reporter);
                        }

                    }

                }

                for (int i = 0; i < id_list.length; i++) {
                    String target = id_list[i];
                    String[] reporters = reportMap.getOrDefault(target, "").split(" ");
                    if (reporters.length >= k) {
                        for (String reporter : reporters) {
                            mailMap.put(reporter, mailMap.getOrDefault(reporter, 0) + 1);
                        }
                    }
                }

                for (int i = 0; i < id_list.length; i++) {
                    String id = id_list[i];
                    answer[i] = mailMap.getOrDefault(id, 0);
                }

                return answer;
            }
        }

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        for (int i : Solution.solution(id_list, report, 2)) {
            System.out.println(i);
        }
    }
}
