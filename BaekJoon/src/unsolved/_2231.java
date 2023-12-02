import java.util.Scanner;

public class _2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strN = sc.nextLine();
        sc.close();

        int x = strN.length();
        int n = Integer.parseInt(strN);
        int start = n - (9 * (x-1));

        if (n < 10) {
            System.out.println(n);
        } else {
            for (int i = start; i < n; i++) {
                int sum = i;

                for (int j = 0; j < x; j++) {
                    String strI = String.valueOf(i);
                    int y = Integer.parseInt(strI.substring(j, j+1));

                    sum += y;
                }

                if (n == sum) {
                    System.out.println(i);
                    return;
                }
            }
            System.out.println(0);
        }
    }
}
