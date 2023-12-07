import java.util.Scanner;

public class _9506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            int n = sc.nextInt();
            sc.nextLine();
            int sum = 0;
            String result = "";

            if (n == -1) {
                run = false;
                break;
            }

            for (int i = 1; i < n ; i++) {
                if (n % i == 0) {
                    sum += i;
                    result += i + " + ";
                }
            }

            if (sum == n) {
                System.out.println(n + " = " + result.substring(0, result.length() - 2));
            }else {
                System.out.println(n + " is NOT perfect.");
            }


        }
    }
}
