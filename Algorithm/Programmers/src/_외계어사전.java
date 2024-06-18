public class _외계어사전 {
    public static void main(String[] args) {
        class Solution {
            public int solution(String[] spell, String[] dic) {
                for (int i = 0; i < dic.length; i++) {
                    if (dic[i].length() < spell.length) {
                        continue;
                    }
                    String word = dic[i];
                    boolean flag = true;
                    for (int j = 0; j < spell.length; j++) {
                        if (!word.contains(spell[j])) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        return 1;
                    }

                }
                return 2;
            }
        }
    }
}
