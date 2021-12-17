package me.hyeonho.java8to11.morder_java_in_action.chap05;

import static me.hyeonho.java8to11.morder_java_in_action.chap04.Dish.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import me.hyeonho.java8to11.morder_java_in_action.chap04.Dish;

public class Reducing {

  public static void main(String... args) throws FileNotFoundException {
//
//
//    List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
//    int sum = numbers.stream().reduce(0, (a, b) -> a + b);
//    System.out.println(sum);

//    int sum2 = numbers.stream().reduce(0, Integer::sum);
//    System.out.println(sum2);
//
//    int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
//    System.out.println(max);
//
//    Optional<Integer> min = numbers.stream().reduce(Integer::min);
//    min.ifPresent(System.out::println);



//    int calories = menu.stream()
//        .map(Dish::getCalories)
//        .reduce(0, Integer::sum);
//    System.out.println("Number of calories:" + calories);
  }

}
