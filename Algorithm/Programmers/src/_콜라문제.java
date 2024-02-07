public class _콜라문제 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int a, int b, int n) {
                int sum = 0;
                int cola = 0;
                int empty = n;
                while (true) {
                    //1. 빈병을 만든다.
                    empty = empty + cola;
                    cola = 0;

                    if (empty < a) {
                        break;
                    }
                    //2. 빈병을 콜라로 바꾼다.
                    cola = (empty / a) * b;
                    empty = empty % a;
                    //3. 바꾼 콜라를 합에 넣어준다.
                    sum += cola;
                }

                return sum;
            }
        }
    }
}


