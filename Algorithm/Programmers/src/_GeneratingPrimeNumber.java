import java.util.ArrayList;
import java.util.List;

public class _GeneratingPrimeNumber {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] nums) {
                int answer = 0;
                for (int i = 0; i < nums.length - 2; i++) {
                    for (int j = i + 1; j < nums.length - 1; j++) {
                        for (int k = j + 1; k < nums.length; k++) {
                            int n = nums[i] + nums[j] + nums[k];
                            int pwN = (int) Math.pow(n, 0.5);
                            boolean add = true;
                            System.out.println(n);
                            for (int l = 2; l <= pwN; l++) {
                                if (n % l == 0) {
                                    add = false;
                                    break;
                                }
                            }
                            if (add) answer++;
                        }
                    }
                }
                return answer;
            }
        }
        int[] arr = {1, 2, 3, 4};
        System.out.println(new Solution().solution(arr));
    }

}
