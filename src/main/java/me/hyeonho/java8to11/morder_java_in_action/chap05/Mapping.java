package me.hyeonho.java8to11.morder_java_in_action.chap05;

import me.hyeonho.java8to11.morder_java_in_action.chap04.Dish;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toList;
import static me.hyeonho.java8to11.morder_java_in_action.chap04.Dish.menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Mapping{

  public static void main(String... args) {
    // map
//    List<String> dishNames = menu.stream()
//        .map(Dish::getName)
//        .collect(toList());
//    System.out.println(dishNames);

    // map
    List<String> words = Arrays.asList("Hello", "World");
//    List<Integer> wordLengths = words.stream()
//        .map(String::length)
//        .collect(toList());
//    System.out.println(wordLengths);

    // flatMap
//    words.stream()
//        .flatMap(str -> Arrays.stream(str.split("")))
//        .distinct()
//        .forEach(System.out::println);
//
//    // flatMap
//    List<Integer> numbers1 = Arrays.asList(1,2,3);
//    List<Integer> numbers2 = Arrays.asList(3,4);
//
//    List<int[]> collect = numbers1.stream()
//            .flatMap(i -> numbers2.stream()
//                    .filter(j -> (i + j) % 3 == 0)
//                    .map(j -> new int[]{i,j})
//            )
//            .collect(toList());
//    collect.forEach(ints -> System.out.println(ints.length));


//    List<Integer> collect = numbers1.stream()
//            .map(integer -> integer * integer)
//            .collect(toList());
//    System.out.println(collect);



//    List<int[]> pairs = numbers1.stream()
//        .flatMap((Integer i) -> numbers2.stream()
//            .map((Integer j) -> new int[]{i, j})
//        )
//        .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
//        .collect(toList());
//    pairs.forEach(pair -> System.out.printf("(%d, %d)", pair[0], pair[1]));
  }

}
