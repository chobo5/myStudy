package herb;

import java.math.BigInteger;

public class _순열의개수구하기 {
    public static long solution(int n, int r) {
        if (r > n) {
            return 0;
        }
        BigInteger result = factorial(n).divide(factorial(n - r));
        if (result.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
            throw new ArithmeticException("결과값이 long의 범위를 벗어났습니다.");
        }
        return result.longValue();
    }

    public static BigInteger factorial(int a) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= a; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
