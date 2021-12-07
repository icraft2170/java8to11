package me.hyeonho.java8to11.thejava;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class App {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("\nspring 으로 시작하는 수업\n");

        springClasses.stream()
                .map(OnlineClass::getTitle)
                .filter(title -> title.startsWith("spring"))
                .forEach(System.out::println);


        System.out.println("\nclose 되지 않은 수업\n");

        keesunEvents.stream()
                .flatMap(Collection::stream)
                .filter(Predicate.not(OnlineClass::isClosed))
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);



        System.out.println("\n수업 이름만 모아서 스트림 만들기\n");

        List<String> collect = springClasses.stream()
                .map(OnlineClass::getTitle)
                .collect(toList());

        collect.forEach(System.out::println);


        System.out.println("\n두 수업 목록에 들어있는 모든 수업 아이디 출력\n");

        keesunEvents.stream()
                .flatMap(Collection::stream)
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("\n10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만\n");

        IntStream.iterate(10, i -> i + 1)
                        .skip(10)
                        .limit(10)
                        .forEach(System.out::println);


        System.out.println("\n자바 수업 중에 Test가 들어있는 수업이 있는지 확인\n");

        boolean test = javaClasses.stream()
                .anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println("test = " + test);

        System.out.println("\n스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기\n");

        List<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().contains("spring"))
                .collect(toList());

        spring.forEach(System.out::println);


    }


}

@AllArgsConstructor
@Data
class OnlineClass{
    private int id;
    private String title;
    private boolean closed;
}
