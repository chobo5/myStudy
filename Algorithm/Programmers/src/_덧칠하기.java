public class _덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int start = section[0];
        int end = section[0] + m - 1;
        int answer = 1;
        for(int i = 0; i < section.length; i++) {
            if (section[i] >= start && section[i] <= end) {
                continue;
            } else {
                start = section[i];
                end = section[i] + (m - 1);
                answer++;
            }
        }

        return answer;
    }
}
