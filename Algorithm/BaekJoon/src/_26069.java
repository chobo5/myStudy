import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st;
        Set<String> hashSet = new HashSet<>();
        hashSet.add("ChongChong");
        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            st = new StringTokenizer(str, " ");
            String A = st.nextToken();
            String B = st.nextToken();

            if( hashSet.contains(A) || hashSet.contains(B)) {
                hashSet.add(A);
                hashSet.add(B);
            }
        }

        System.out.println(hashSet.size());

    }
}
