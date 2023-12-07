import java.util.Scanner;

public class _15894 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();
        //4
        //8 = 4 -1 + 5
        //12 = 8 - 2 + 6
        //16 = 12 - 3 + 7
        //   = 16 - 4 + 8
        System.out.print(n * 4);
    }
}
