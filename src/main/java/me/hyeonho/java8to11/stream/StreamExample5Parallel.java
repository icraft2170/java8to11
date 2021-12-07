package me.hyeonho.java8to11.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class StreamExample5Parallel {
    public static void main(String[] args) {
        final int[] sum = { 0 };

        // Single Core
        IntStream.range(0, 5000)
                .forEach(i -> sum[0] += i);

        System.out.println("stream sum (with side-effect)" + sum[0]);

        // 동시성 문제 발생 ( 멀티 쓰레드 )
        final int[] sumWithParallel = { 0 };
        IntStream.range(0, 5000)
                .parallel()
                .forEach(i -> sumWithParallel[0] += i);

        System.out.println("Parallel sum(with side-effect) = " + sumWithParallel[0]);

        System.out.println("stream sum(no side-effect) = " +
                IntStream.range(0, 5000)
                        .sum()
        );
        System.out.println("Parallel sum(no side-effect) = " +
                IntStream.range(0, 5000)
                        .parallel()
                        .sum()
        );

        long startTime = System.currentTimeMillis();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        numbers
                .parallelStream()
                .map(integer -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return integer;
                })
                .forEach(System.out::println);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms");


        startTime = System.currentTimeMillis();
        numbers
                .stream()
                .map(integer -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return integer;
                })
                .forEach(System.out::println);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms");


        startTime = System.currentTimeMillis();
        numbers
                .parallelStream()
                .map(integer -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return integer;
                })
                .forEach(System.out::println);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms");
    }

}
