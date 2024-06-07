package unsolved;

import java.util.StringTokenizer;

public class _공원산책 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(String[] park, String[] routes) {
                int[] answer = new int[2];
                StringTokenizer st;
                boolean flag = true;
                for (int i = 0; i < park.length; i++) {
                    String str = park[i];
                    for (int j = 0; j < str.length(); j++) {
                        char point = str.charAt(j);
                        if (point == 'S') {
                            answer[0] = i;
                            answer[1] = j;
                            flag = false;
                            break;
                        }
                    }

                    if (!flag) {
                        break;
                    }
                }

                for (int k = 0; k < routes.length; k++) {
                    st = new StringTokenizer(routes[k], " ");
                    String direction = st.nextToken();
                    int num = Integer.parseInt(st.nextToken());
                    if (direction.equals("S")) {
                        int y = answer[0] + num;
                        if (y > park.length - 1) {
                            continue;
                        }
                        for (int i = 1; i <= num; i++) {
                            if (park[answer[0] + i].charAt(answer[1]) == 'X') {
                                break;
                            }
                        }
                        answer[0] += num;
                    } else if (direction.equals("N")) {
                        int y = answer[0] - num;
                        if (y < 0) {
                            continue;
                        }

                        for (int i = 1; i <= num; i++) {
                            if (park[answer[0] - i].charAt(answer[1]) == 'X') {
                                break;
                            }
                        }

                        answer[0] -= num;
                    } else if (direction.equals("W")) {
                        int x = answer[1] - num;
                        if (x < 0) {
                            continue;
                        }
                        for (int i = 1; i <= num; i++) {
                            if (park[answer[0]].charAt(answer[1] - i) == 'X') {
                                break;
                            }
                        }
                        answer[1] -= num;
                    } else { //E
                        int x = answer[1] + num;
                        if (x > park.length) {
                            continue;
                        }

                        for (int i = 1; i <= num; i++) {
                            if (park[answer[0]].charAt(answer[1] + i) == 'X') {
                                break;
                            }
                        }
                        answer[1] += num;
                    }
                }

                return answer;

            }

        }
    }
}
