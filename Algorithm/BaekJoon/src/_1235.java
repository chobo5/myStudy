import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _1235 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.readLine();
        }
        Set<String> set = new HashSet<>();
        int k = 1;
        while (true) {
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = arr[i].length() - 1; j > arr[i].length() - (1 + k); j--) {
                    sb.append(arr[i].charAt(j));
                }
                set.add(sb.toString());
            }
            if (set.size() == n) {
                break;
            } else {
                k++;
                set.clear();
            }
        }
        System.out.println(k);
    }
}
