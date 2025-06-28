import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] inputs = new int[n];
        int max = 2;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            max = Math.max(max, x);
            inputs[i] = max;
        }

        //false is prime
        boolean[] primes = new boolean[max + 1];
        primes[0] = true;
        primes[1] = true;
        for (int i = 2; i < Math.sqrt(max); i++) {
            for (int j = 2; j <= max / i; j++) {
                primes[i * j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int count = goldPartition(inputs[i], primes);
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static int goldPartition(int x, boolean[] primes) {
        int count = 0;
        Map<Integer, Integer> history = new HashMap<>();
        for (int i = 2; i <= x; i++) {
            if (!primes[i] && !primes[x - i]) {
                history.put(i, x - i);
                if (history.get(x - i) != null) {
                    count--;
                }
                count++;
            }
        }

        return count;
    }
}
