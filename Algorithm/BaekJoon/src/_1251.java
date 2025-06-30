import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int length =  word.length();

        List<String> words = new ArrayList<>();
        for (int i = 1; i <= length - 2; i++) {
            for (int j = 1; j <= length - i - 1; j++) {
                int k = length - i - j;
                String newWord = divide(i, j, k, word);
                words.add(newWord);
            }
        }

        words.sort(String::compareTo);

        System.out.println(words.get(0));

    }

    private static String divide(int i, int j, int k, String word) {
        String part1 = word.substring(0, i);
        String part2 = word.substring(i, i+j);
        String part3 = word.substring(i+j, i+j+k);

        return reverse(part1) + reverse(part2) + reverse(part3);
    }

    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb.reverse().toString();
    }
}
