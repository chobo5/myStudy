package bitcamp.util;

public class Test {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
//        list.add(new String("aaa")); // aaa,
//        list.add(new String("bbb")); // aaa, bbb,
//        list.add(new String("ccc")); // aaa, bbb, ccc,
//        list.add(new String("ddd")); // aaa, bbb, ccc, ddd,
//
//        System.out.println(list.remove("xxx"));
//        System.out.println(list.remove("ccc"));
//        System.out.println(list.remove("ddd"));
//        System.out.println(list.remove("aaa"));
//        System.out.println(list.remove("bbb"));
//        list.add(new String("xxx"));
//        list.add(new String("yyy"));
//        list.add(new String("zzz"));
//        list.remove(2); // aaa, bbb, ddd,
//        list.remove(2); // aaa, bbb,
//        list.remove(0); // bbb,
//        list.remove(0); //
//    // 맨 앞
//    list.add(0, new String("xxx")); // xxx, aaa, bbb, ccc, ddd,
//
//    // 맨 뒤
//    list.add(5, new String("yyy")); // xxx, aaa, bbb, ccc, ddd, yyy,
//
//    // 기존 값 자리
//    list.add(1, new String("mmm")); // xxx, mmm, aaa, bbb, ccc, ddd, yyy,
//    list.add(3, new String("ttt")); // xxx, mmm, aaa, ttt, bbb, ccc, ddd, yyy,
//    list.add(7, new String("ppp")); // xxx, mmm, aaa, ttt, bbb, ccc, ddd, ppp, yyy,

//        Object[] arr = list.toArray();
//        for (Object value : arr) {
//            System.out.printf("%s, ", value);
//        }
//        System.out.println();

//        String[] arr = list.toArray(new String[0]);


//    System.out.println(list.get(0));
//    System.out.println(list.get(1));
//    System.out.println(list.get(2));
//    System.out.println(list.get(3));
//    System.out.println(list.get(4));

        //스택 테스트
//        System.out.println(list.empty());
//        System.out.println(list.push("1"));
//        System.out.println(list.push("2"));
//        System.out.println(list.push("3"));
//        System.out.println(list.push("4"));
//        System.out.println(list.empty());
//        System.out.println(list.peek());
//        System.out.println(list.pop());
//        System.out.println(list.pop());
//        System.out.println(list.pop());
//        System.out.println(list.pop());
//        System.out.println(list.pop());

        //큐 테스트
        System.out.println(queue.offer("a"));
        System.out.println(queue.offer("b"));
        System.out.println(queue.offer("c"));
        System.out.println(queue.offer("d"));
//        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
//        System.out.println(queue.poll());
        System.out.println(queue.peek());



    }

}
