import java.util.Stack;

public class _햄버거만들기 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] ingredient) {
                Stack<Integer> ingredients = new Stack<>();
                int answer = 0;
                for (int i = 0; i < ingredient.length; i++) {
                    ingredients.push(ingredient[i]);
                    if (ingredients.size() >= 4) {
                        if (ingredients.get(ingredients.size() - 1) == 1 && ingredients.get(ingredients.size() - 2) == 3
                        && ingredients.get(ingredients.size() - 3) == 2 && ingredients.get(ingredients.size() - 4) == 1) {
                            answer += 1;
                            for (int j = 0; j < 4; j++) {
                                ingredients.pop();
                            }
                        }
                    }
                }
                return answer;
            }

        }
    }
}
