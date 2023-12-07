import java.util.*;


public class _7785 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Set<String> hashSet = new HashSet<String>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String enter = sc.nextLine();
            String log = name + enter;

            if (enter.equals(" leave") ) {
                hashSet.remove(name+" enter");
            } else {
                hashSet.add(log);
            }

        }

        ArrayList<String> arrayList = new ArrayList<>(hashSet);
        Collections.sort(arrayList, Collections.reverseOrder());
        for (String record : arrayList) {
            System.out.println(record.substring(0, record.length() - 6));
        }




    }
}
