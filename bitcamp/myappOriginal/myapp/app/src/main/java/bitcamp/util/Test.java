package bitcamp.util;

public class Test {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new String("aaa"));
        list.add(new String("bbb"));
        list.add(new String("ccc"));
        list.add(new String("ddd"));

        System.out.println(list.first.value);
        System.out.println(list.first.next.value);
        System.out.println(list.first.next.next.value);
        System.out.println(list.first.next.next.next.value);
        System.out.println(list.last.value);


    }

}
