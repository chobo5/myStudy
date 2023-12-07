import java.util.Scanner;

public class _1735 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int up1 = sc.nextInt();
        int down1 = sc.nextInt();
        sc.nextLine();
        int up2 = sc.nextInt();
        int down2 = sc.nextInt();
        sc.close();

        int up = up1 * down2 + up2 * down1;
        int down = down1 * down2;
        int value = gcd(up, down);
        System.out.println(up / value + " " + down / value);


    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
