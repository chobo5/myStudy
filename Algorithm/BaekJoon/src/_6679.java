public class _6679 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1000; i <= 9999; i++) {
            int a = calculate(i, 10);
            int b = calculate(i, 12);
            int c = calculate(i, 16);
            if (a == b && b == c) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);

    }

    static int calculate(int n, int to) {
        int sum = 0;
        while (n >= to) {
            sum += n % to;
            n /= to;
        }
        sum += n;
        return sum;
    }
}
