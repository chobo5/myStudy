import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _1620 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        HashMap<Integer, String> map1 = new HashMap<Integer, String>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();

        for (int i = 0; i < n ; i++) {
            String name = sc.nextLine();
            map1.put(i+1, name);
            map2.put(name, i+1);

        }

        for (int i = 0; i < m; i++) {
            String input = sc.nextLine();
            try {
                int id = Integer.parseInt(input);
                System.out.println(map1.get(id));
            } catch (NumberFormatException e) {
                System.out.println(map2.get(input));
            }

        }

    }
}
