import java.util.*;

public class _14425 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nLength = sc.nextInt();
        int sLength = sc.nextInt();
        sc.nextLine();
        Set<String> hashSet = new HashSet<String>();
        String[] s = new String[sLength];
        int count = 0;

        for (int i = 0; i < nLength; i++) {
            hashSet.add(sc.nextLine());
        }

        for (int i = 0; i < sLength; i++) {
            String x = sc.nextLine();
            if (hashSet.contains(x)) {
                count += 1;
            }
        }

        sc.close();

        System.out.println(count);

    }
}
