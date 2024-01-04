public class _이진변환반복하기 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(String s) {
                int[] answer = new int[2];
                int zeroCount = 0;
                int count = 0;
                String temp = s;
                StringBuilder sb;

                while (true) {
                    sb = new StringBuilder();
                    for (int i = 0; i < temp.length(); i++) {
                        char c = temp.charAt(i);
                        if (c == '0') {
                            zeroCount++;
                        } else {
                            sb.append(c);
                        }
                    }
                    count++;
                    if (sb.toString().equals("1")) {
                        break;
                    } else {
                        temp = Integer.toBinaryString(sb.toString().length());
                    }
                }
                answer[0] = count;
                answer[1] = zeroCount;
                return answer;
            }
        }

        System.out.println(new Solution().solution("110010101001"));
    }
}
