public class _키패드누르기 {
    public static void main(String[] args) {
        class Solution {
            public String solution(int[] numbers, String hand) {
                StringBuilder answer = new StringBuilder();
                int rightPosition = 12; //#
                int leftPosition = 10; //*
                for (int i = 0; i < numbers.length; i++) {
                    int n = numbers[i];
                    if (n == 0) n = 11;
                    if (n % 3 == 1) {
                        leftPosition = n;
                        answer.append("L");
                    } else if (n % 3 == 0) {
                        rightPosition = n;
                        answer.append("R");
                    } else {
                        int leftLength = 0;
                        if (leftPosition % 3 == 1) {
                            leftLength = Math.abs((n - (leftPosition + 1))) / 3 + 1;
                        } else {
                            leftLength = Math.abs(n - leftPosition) / 3;
                        }

                        int rightLength = 0;
                        if (rightPosition % 3 == 0) {
                            rightLength = Math.abs((n - (rightPosition - 1))) / 3 + 1;
                        } else {
                            rightLength = Math.abs(n - rightPosition) / 3;
                        }

                        if (leftLength > rightLength) {
                            answer.append("R");
                            rightPosition = n;
                        } else if (leftLength < rightLength) {
                            answer.append("L");
                            leftPosition = n;
                        } else {
                            if (hand.equals("right")) {
                                answer.append("R");
                                rightPosition = n;
                            } else {
                                answer.append("L");
                                leftPosition = n;
                            }
                        }


                    }

                }
                return answer.toString();
            }


        }
    }
}
