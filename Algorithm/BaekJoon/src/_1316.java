import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int count = 0;
        Set<String> hashSet;
        loop:
        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            String[] strArr = str.split("");
            hashSet = new HashSet<>();
            hashSet.add(strArr[0]);
            if (strArr.length == 1) {
                count++;
                continue;
            }

            for (int j = 1; j < strArr.length; j++) {
                if (!strArr[j].equals(strArr[j - 1]) ) {
                    if (hashSet.contains(strArr[j])) {
                        continue loop;
                    } else {
                        hashSet.add(strArr[j]);
                    }
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
