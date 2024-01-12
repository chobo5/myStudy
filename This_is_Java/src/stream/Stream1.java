package stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1 {
    static Set<String> set = new HashSet<>();

    static List<Student> list = new ArrayList<>();

    public static void main(String[] args) {
        set.add("홍길동");
        set.add("임꺽정");
        set.add("김자바");

        list.add(new Student("홍길동", 90));
        list.add(new Student("김길돌", 70));
        list.add(new Student("이길돌", 100));
        list.add(new Student("박길돌", 80));

//        Stream<String> stream = set.stream();
//        stream.forEach(name -> System.out.println(name));
//        stream.forEach(System.out::println);

        //컬렉션의 내부반복자를 이용한 병렬 처리
//        Stream<String> parallelStream = set.parallelStream();
//        parallelStream.forEach(name -> System.out.println(name + ": " + Thread.currentThread().getName()));


        //중간 처리 + 최종처리
        Stream<Student> studentStream = list.stream();
        IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());
        double avg = scoreStream.average().getAsDouble();
        System.out.println(avg);

        double avg2 = list.stream()
                .mapToInt(student -> student.getScore())
                .average().getAsDouble();

        System.out.println("평균점수: " + avg2);

        list.forEach(student -> System.out.println(student.getName() + " " + student.getScore()));





    }



}
