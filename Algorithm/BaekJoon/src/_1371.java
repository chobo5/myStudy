import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1371 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer[][] arr = new Integer[26][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = i;
            arr[i][1] = 0;
        }
        String str;
        List<String> strList = new ArrayList<>();
        while((str = in.readLine()) != null) {
            strList.add(str);
        }

        for (String s : strList) {
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i);
                if (c == ' ') {
                    continue;
                }
                arr[c - 'a'][1] += 1;
            }
        }

        Arrays.sort(arr, (o1, o2) -> o2[1] - o1[1]);
        int value = arr[0][1];
        List<Character> list = new ArrayList<>();
        list.add((char) (arr[0][0] + 'a'));

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][1] == value) {
                list.add((char) (arr[i][0] + 'a'));
            } else {
                break;
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        System.out.println(sb);
    }
}
