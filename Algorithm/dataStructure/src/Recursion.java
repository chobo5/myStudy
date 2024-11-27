public class Recursion {
    /*
    재귀는 어떤 문제나 함수 등이 자신과 성격이 똑같지만 크기나 더 작은 문제를 하나 이상 포함하고 있을때
    재귀적 구조를 갖고 있다고 말한다.
    재귀는 컴퓨터 과학 이론의 근간을 이루는 중요 개념으로 수열의 점화식, 귀납법도 모두 이 틀에 속한다.
     */
    public static void main(String[] args) {
        //초항이 1, 공차가 3인 점화식
        int answer1 = sequence(3);
        System.out.println(answer1);

        //피보나치 수열
        int answer2 = fibonacciRecursion(20);
        System.out.println(answer2);

        //피보나치 수열 비재귀
        int answer3 = fibonacciSave(20);
        System.out.println(answer3);

        //하노이탑



    }

    private static int sequence(int n) {
        if (n == 1) {
            return 1;
        }
        return sequence(n - 1) + 3;

    }

    private static int fibonacciRecursion(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    private static int fibonacciSave(int n) {
        int[] save = new int[n + 1];
        save[0] = 0;
        save[1] = 1;
        save[2] = 1;
        if (n < 3) {
            return save[n];
        }

        for (int i = 3; i <= n; i++) {
            save[i] = save[i - 1] + save[i - 2];
        }
        return save[n];
    }

    private static int hanoi()
}
