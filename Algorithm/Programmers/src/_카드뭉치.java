public class _카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        int oneIndex = 0;
        int twoIndex = 0;
        for (int i = 0; i < goal.length; i++) {
            if (oneIndex <= (cards1.length - 1) && goal[i].equals(cards1[oneIndex])) {
                oneIndex++;
            } else if (twoIndex <= (cards2.length - 1) && goal[i].equals(cards2[twoIndex])) {
                twoIndex++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}
