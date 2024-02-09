package unsolved;

import java.util.ArrayList;
import java.util.List;

public class _옹알이2 {
    public static void main(String[] args) {
        class Solution {
            public int solution(String[] babbling) {
                String[] possible = {"aya", "ye", "woo", "ma"};
                List<String> list = new ArrayList<>();
                //1개 골랐을때
                list.add(possible[0]);
                list.add(possible[1]);
                list.add(possible[2]);
                list.add(possible[3]);
                int answer = 0;
                //2개 골랐을때
                for (int i = 0; i < possible.length; i++) {
                    for (int j = 0; j < possible.length; j++) {
                        if(i != j) list.add(possible[i] + possible[j]);
                    }
                }

                for (int i = 0; i < possible.length; i++) {
                    for (int j = 0; j < possible.length; j++) {
                        for (int k = 0; k < possible.length; k++) {
                            if(i != j || j != k) list.add(possible[i] + possible[j] + possible[k]);
                        }
                    }
                }

                for (int i = 0; i < possible.length; i++) {
                    for (int j = 0; j < possible.length; j++) {
                        for (int k = 0; k < possible.length; k++) {
                            for (int l = 0; l < possible.length; l++) {
                                if(i != j || j != k || k != l) list.add(possible[i] + possible[j] + possible[k] + possible[l]);
                            }
                        }
                    }
                }

                for (int i = 0; i < babbling.length; i++) {
                    if (list.contains(babbling[i])) answer++;
                }

                return answer;
            }
        }

        String[] possible = {"aya", "ye", "woo", "ma"};
        List<String> list = new ArrayList<>();
        //1개 골랐을때
        list.add(possible[0]);
        list.add(possible[1]);
        list.add(possible[2]);
        list.add(possible[3]);
        int answer = 0;
        //2개 골랐을때
        for (int i = 0; i < possible.length; i++) {
            for (int j = 0; j < possible.length; j++) {
                if(i != j) list.add(possible[i] + possible[j]);
            }
        }

        for (int i = 0; i < possible.length; i++) {
            for (int j = 0; j < possible.length; j++) {
                for (int k = 0; k < possible.length; k++) {
                    if(i != j && j != k) list.add(possible[i] + possible[j] + possible[k]);
                }
            }
        }

        for (int i = 0; i < possible.length; i++) {
            for (int j = 0; j < possible.length; j++) {
                for (int k = 0; k < possible.length; k++) {
                    for (int l = 0; l < possible.length; l++) {
                        if(i != j && j != k && k != l) list.add(possible[i] + possible[j] + possible[k] + possible[l]);
                    }
                }
            }
        }

        for(String word : list) {
            System.out.println(word);
        }
        System.out.println(list.size());
    }
}
