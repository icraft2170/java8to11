package me.hyeonho.java8to11.stream.prelude;

import java.math.BigInteger;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample1 {
    public static void main(String[] args) {
        // range(1,10) 1 ~ 9
        IntStream.range(1,10).forEach(value -> System.out.print(" " + value));


        System.out.println();
        // rangeClosed(1,10) 1 ~ 10
        IntStream.rangeClosed(1,10).forEach(value -> System.out.print(" " + value));

        IntStream.iterate(1, i -> i + 1).forEach(System.out::println);

        Stream
            .iterate(BigInteger.ONE, i -> i.add(BigInteger.ONE))
            .forEach(System.out::println);
    }
}
