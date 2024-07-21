import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _10448 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] nums = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(in.readLine());
            max = Math.max(max, nums[i]);
        }
        List<Integer> triangles = new ArrayList<>();
        triangles.add(1);
        int index = 2;
        while (true) {
            if (triangles.get(triangles.size() - 1) > max) {
                break;
            }
            triangles.add(triangles.get(triangles.size() - 1) + index++);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < triangles.size(); i++) {
            int x = triangles.get(i);
            for (int j = i; j < triangles.size(); j++) {
                int y = triangles.get(j);
                for (int k = j; k < triangles.size(); k++) {
                    int sum = x + y + triangles.get(k);
                    map.put(sum,1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(map.getOrDefault(nums[i], 0)).append("\n");
        }
        System.out.println(sb);
    }
}
