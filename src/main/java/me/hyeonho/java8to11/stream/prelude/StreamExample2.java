package me.hyeonho.java8to11.stream.prelude;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamExample2 {
    public static void main(String[] args) {

        System.out.println(
                "collect(toList()): " +Stream.of(1, 2, 3, 4, 5, 2)
                .filter(i -> i > 2)
                .map(i -> i * 2)
                .map(i -> "#" + i)
                .collect(toList())
        ); //[#10, #6, #10]

        System.out.println(
                "collect(toSet()): " + Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(toSet())
        ); //[#10, #6]


        System.out.println(
                "collect(joining()): " + Stream.of(1, 2, 3, 4, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(joining(", "))
        ); // #6, #8, #10

        System.out.println(
                "collect(joining()): " + Stream.of(1, 2, 3, 4, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(joining(", ","[ "," ]"))
        ); //[ #6, #8, #10 ]

        System.out.println(
                "collect(joining()): " + Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .distinct()
                        .collect(joining(", ","[ "," ]"))
        ); //[ #6, #10 ]

        final Integer integer127 = 127;
        System.out.println(
                Stream.of(1,2,3,4,5,127)
                        .filter(i -> i == integer127)
                        .findFirst()
        ); // Optional[127]

        final Integer integer128 = 128;
        System.out.println(
                Stream.of(1,2,3,4,5,128)
                        .filter(i -> i == integer128)
                        .findFirst()
        ); // Optional.empty

        System.out.println(
                Stream.of(1,2,3,4,5,128)
                        .filter(i -> i.equals(integer128))
                        .findFirst()
        ); // Optional[128]

        System.out.println(
                Stream.of(1,2,3,4,5,128)
                        .filter(i -> i == 128)
                        .findFirst()
        ); // Optional[128]

        // External Iterator vs Internal Iterator

        // External Iterator
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer i : numbers) {
            System.out.print("i = " + i + ", ");
        }
        System.out.println();
        System.out.println("------------------------------------ ");
        //Internal Iterator
        Stream.of(1,2,3,4,5)
                .forEach(i -> System.out.print("i = " + i  + ", "));




    }
}
