import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _1526 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        in.close();
        int num = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        // 4 7 44 47 74 77 447 474
        // 2개, 4개, 8개
        list.add(4);
        list.add(7);
        int index = 1;
        while (true) {
            boolean flag = true;
            for (int i = (int) (list.size() - Math.pow(2, index)); i <= list.size() - 1; i++) {
                num = list.get(i) * 10 + 4;
                if (num > n) {
                    flag = false;
                    break;
                }
                temp.add(num);
                num = list.get(i) * 10 + 7;
                if (num > n) {
                    flag = false;
                    break;
                }
                temp.add(num);
            }
            list.addAll(temp);
            temp.clear();
            index++;

            if (!flag) {
                break;
            }

        }
        if (n >= 4 && n < 7) {
            System.out.println(4);
        } else {
            System.out.println(list.get(list.size() - 1));
        }

    }
}
