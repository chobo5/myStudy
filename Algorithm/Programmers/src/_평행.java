public class _평행 {
    class Solution {
        public int solution(int[][] dots) {
            int answer = 0;
            int kUp = 0;
            int kDown = 0;
            if(calculate(dots[0], dots[1], dots[2], dots[3]) == 1 ||
                    calculate(dots[0], dots[2], dots[1], dots[3]) == 1 ||
                    calculate(dots[0], dots[3], dots[1], dots[2]) == 1) {
                return 1;
            };

            return 0;
        }

        public int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }

        public int calculate(int[] a1, int[] a2, int[] b1, int[] b2) {
            int up1 = a2[1] - a1[1];
            int down1 = a2[0] - a1[0];
            int gcd1 = gcd(up1, down1);
            up1 /= gcd1;
            down1 /= gcd1;

            int up2 = b2[1] - b1[1];
            int down2 = b2[0] - b1[0];
            int gcd2 = gcd(up2, down2);
            up2 /= gcd2;
            down2 /= gcd2;

            if (up1 == up2 && down1 == down2) {
                return 1;
            }
            return 0;
        }

    }
}
