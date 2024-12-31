package herb;

public class _최소공배수의합 {
    public static int solution(int[] arr) {
        int answer = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int a = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int b = arr[j];
                answer += (a * b) / gcd(a, b);
            }
        }
        return answer;

    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] input = {1 , 2 , 3};
        System.out.println(solution(input));
    }
}
