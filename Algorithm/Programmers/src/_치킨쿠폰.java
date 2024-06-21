public class _치킨쿠폰 {
    class Solution {
        public int solution(int chicken) {
            int answer = 0;
            int coupon = chicken;
            while (coupon >= 10) {
                int serviceChicken = coupon / 10;
                answer += serviceChicken;
                coupon = coupon % 10;
                coupon += serviceChicken;

            }
            return answer;
        }
    }
}

/*
1081
108 10 1 +
1   9  10
 */
