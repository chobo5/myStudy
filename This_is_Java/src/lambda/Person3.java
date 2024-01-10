package lambda;

public class Person3 {

    @FunctionalInterface
    interface Comparable {
        int compare(String a, String b);
    }

    public void ordering(Comparable comparable) {
        String a = "홍길동";
        String b = "김길동";

        int result = comparable.compare(a, b);

        if(result < 0) {
            System.out.printf("%s은 %s 보다 앞에 옵니다.\n", a, b);
        } else if (result == 0) {
            System.out.printf("%s은 %s과 같습니다.\n", a, b);
        } else {
            System.out.printf("%s은 %s 보다 뒤에 옵니다.\n", a, b);
        }
    }

    public Member getMember1(Creatable1 creatable1) {
        String id = "Winter";
        Member member = creatable1.create(id);
        return member;
    }

    public Member getMember2(Creatable2 creatable2) {
        String id = "Winter";
        String name = "겨울";
        Member member = creatable2.create(id, name);
        return member;
    }
}
