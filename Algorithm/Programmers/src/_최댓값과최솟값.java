public class _최댓값과최솟값 {
    class Solution {
        public String solution(String s) {

            String[] strArr = s.split(" ");
            int max = Integer.parseInt(strArr[0]);
            int min = Integer.parseInt(strArr[0]);


            for (int i = 1; i < strArr.length; i++) {
                int x = Integer.parseInt(strArr[i]);
                if (x > max) {
                    max = x;
                }
                if (x < min) {
                    min = x;
                }
            }
            return Integer.toString(min) + " " + Integer.toString(max);
        }
    }
}
