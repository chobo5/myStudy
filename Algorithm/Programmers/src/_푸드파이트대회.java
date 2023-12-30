public class _푸드파이트대회 {
    public static void main(String[] args) {
        class Solution {
            public String solution(int[] food) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < food.length; i++) {
                    for (int j = 1; j <= food[i] / 2; j++) {
                        sb.append(i);
                    }
                }
                String result = sb.toString() + "0";
                result = result + sb.reverse();
                return result;
            }
        }
    }
}