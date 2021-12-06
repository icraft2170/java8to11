package me.hyeonho.java8to11.stream.prelude;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StreamPrelude {
    public static void main(String[] args) {
        final int abs1 = Math.abs(-1);
        final int abs2 = Math.abs(1);

        System.out.println("abs1 = " + abs1);
        System.out.println("abs2 = " + abs2);
        System.out.println("abs1 == abs2 is " + (abs1 == abs2));

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        int minInteger = Math.abs(Integer.MIN_VALUE);
        System.out.println("minInteger = " + minInteger);
    }

}