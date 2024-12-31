package herb;


public class _소수의합 {
    public static int solution(int a) {
        int answer = 2 + 3; //a >= 4
        //0 1 2 3 4
        boolean[] checkArr = new boolean[a + 1]; // true - 소수가 아닌수 , false - 소수
        checkArr[0] = checkArr[1] = checkArr[4] = true;

        for (int i = 2; i <= Math.sqrt(a); i++) {
            //소수가 아닌수는 넘어간다.
            if (checkArr[i]) {
                continue;
            }

            //어떤수의 제곱수, 배수는 소수가 아니다.
            for (int j = i * i; j < checkArr.length; j += i) {
                checkArr[j] = true;
            }
        }


        for (int i = 5; i < checkArr.length; i++) {
            if (!checkArr[i]) {
                answer += i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(30));
    }
}

//SELECT
//name AS 이름,
//CASE
//WHEN absence_count >= 4 THEN 'F'
//WHEN score >= 90 THEN 'A'
//WHEN score >= 80 THEN 'B'
//WHEN score >= 70 THEN 'C'
//WHEN score >= 60 THEN 'D'
//ELSE 'F'
//END AS 등급
//        FROM 코딩테스트_점수;