import linkedList.LinkedList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        //추가
        linkedList.add("aaa");
        linkedList.add("bbb");
        linkedList.add("ccc");

        //삽입
        linkedList.add(1, "dddd");
        linkedList.add(3, "eeee");
        linkedList.add(0, "ffff");
        linkedList.add(6, "gggg");

        //수정
        linkedList.set(0, "ffff수정");
        linkedList.set(2, "dddd수정");
        linkedList.set(6, "gggg수정");

        //배열 반환
//        Object[] objArr =  linkedList.toArray();
//        for(Object obj : objArr) {
//            System.out.println(obj);
//        }

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + "  ");
        }
        System.out.println();

        //삭제
//        System.out.println(linkedList.remove(0) + " 첫번째 삭제");
//        System.out.println(linkedList.remove(linkedList.size() - 1) + " 맨뒤 삭제");
//        System.out.println(linkedList.remove(2) + " 중간 삭제");

        //값으로 삭제
        System.out.println(linkedList.remove("ffff수정"));
        System.out.println(linkedList.remove("gggg수정"));
        System.out.println(linkedList.remove("bbb"));

        linkedList.add(0, "hhh"); //hhh aaa  dddd수정  eeee  ccc
        linkedList.add(3, "iii"); //hhh aaa  dddd수정 iii eeee  ccc
        linkedList.add(6, "jjj"); //hhh aaa  dddd수정 iii eeee  ccc  jjj


        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + "  ");
        }

    }


}