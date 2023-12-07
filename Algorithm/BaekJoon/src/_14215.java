import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _14215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] array = {a , b, c};
        Arrays.sort(array);
        if (array[0] + array[1] <= array[2]) {
            System.out.println((array[0] + array[1]) * 2 - 1);
        } else {
            System.out.println(Arrays.stream(array).sum());
        }
    }
}
