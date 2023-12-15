import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int count = 0;
        in.readLine();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            String str = in.readLine() + count;
            if (str.equals("ENTER" + count)) {
                count += 1;

            } else {
                set.add(str);
            }


        }
//        Iterator iterator = set.iterator();
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        System.out.println(set.size());

    }
}
