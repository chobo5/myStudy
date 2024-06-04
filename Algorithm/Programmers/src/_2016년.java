public class _2016년 {
    public static void main(String[] args) {
        class Solution {
            public String solution(int a, int b) {

                int days = 0;
                for (int i = 1; i < a; i++) {
                    if (i == 2) {
                        days += 29;
                        continue;
                    }


                    if (i % 2 == 0) {
                        if (i >= 8) {
                            days += 31;
                        } else {
                            days += 30;
                        }
                    } else {
                        if (i <= 7) {
                            days += 31;
                        } else {
                            days += 30;
                        }

                    }
                }

                int day = (days + b - 1) % 7;
                String[] names = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
                return names[day];
            }
        }

    }
}
