import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        User[] users = new User[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            users[i] = new User(i, Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(users, (o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.order - o2.order;
            }
            return o1.age - o2.age;
        });

        for (int i = 0; i < users.length; i++) {
            sb.append(users[i].age).append(" ").append(users[i].name).append("\n");
        }
        System.out.println(sb);

    }

    static class User {
        int order;
        int age;
        String name;

        public User(int order, int age, String name) {
            this.order = order;
            this.age = age;
            this.name = name;
        }
    }
}
