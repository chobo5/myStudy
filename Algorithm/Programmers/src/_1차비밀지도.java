import javax.crypto.spec.PSource;

public class _1차비밀지도 {
    public static void main(String[] args) {
        class Solution {
            public String[] solution(int n, int[] arr1, int[] arr2) {
                String[] answer = new String[n];
                String[] map1 = new String[n];
                String[] map2 = new String[n];
                StringBuilder sb;
                for (int i = 0; i < n; i++) {
                    String line1 = Integer.toBinaryString(arr1[i]);
                    String line2 = Integer.toBinaryString(arr2[i]);

                    map1[i] = line1;
                    map2[i] = line2;
                }

                for (int i = 0; i < n; i++) {
                    String str1 = makeLength(map1[i], n);
                    String str2 = makeLength(map2[i], n);
                    String st = "";
                    for (int j = 0; j < n; j++) {
                        char c1 = str1.charAt(j);
                        char c2 = str2.charAt(j);
                        String s = c1 == '1' || c2 == '1' ? "#" : " ";
                        st += s;
                    }
                    answer[i] = st;
                }
                return answer;
            }

            public String makeLength(String string, int n) {
                if (string.length() < n) {
                    String zero = "";
                    for (int i = 0; i < n - string.length(); i++) {
                        zero += "0";
                    }
                    string = zero + string;
                }
                return string;
            }

        }

        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(new Solution().solution(5, arr1, arr2));
    }
}
