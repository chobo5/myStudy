package chapter02;

public class Practice {
    private static int callCount = 0;

    public static void main(String[] args) {
        // an = 5a(n-1) + 3, a1 = 0의 n번째 항을 구하는 재귀 알고리즘을 작성하시오
        int third = ap(3);
        System.out.println(third);

        // 피보나치 수열의 호출 횟수 세기
        int fibResult = fib(5);
        System.out.println(fibResult);
        System.out.println(callCount);

    }

    public static int ap(int n) {
        if (n == 1) {
            return 0;
        }
        return 5 * ap(n - 1) + 3;
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        callCount++;
        return fib(n - 1) + fib(n - 2);
    }
}
