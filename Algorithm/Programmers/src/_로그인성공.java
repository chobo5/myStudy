import java.util.HashMap;
import java.util.Map;

public class _로그인성공 {
    class Solution {
        public String solution(String[] id_pw, String[][] db) {
            Map<String, String> dbMap = new HashMap<>();
            for (int i = 0; i < db.length; i++) {
                dbMap.put(db[i][0], db[i][1]);
            }
            if (dbMap.get(id_pw[0]) == null) {
                return "fail";
            } else {
                if (dbMap.get(id_pw[0]).equals(id_pw[1])) {
                    return "login";
                }
                return "wrong pw";
            }
        }
    }

}
