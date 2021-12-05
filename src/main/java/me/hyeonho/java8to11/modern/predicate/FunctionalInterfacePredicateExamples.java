package me.hyeonho.java8to11.modern.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 */
public class FunctionalInterfacePredicateExamples {

    public static void main(String[] args) {

        final Predicate<Integer> isPositive = i -> i > 0;
        final Predicate<Integer> isZero = i -> i == 0;
        final Predicate<Integer> isFalse = i -> false;
        final Predicate<String> equalString = Predicate.<String>isEqual("Hero");

        System.out.println("test(1) :" + isPositive.test(1));
        System.out.println("test(-1) :" + isPositive.test(-1));
        System.out.println("negate().test(-1):" + isPositive.negate().test(-1));

        // other >= 0
        System.out.println("or(isZero).test(0) = " + isPositive.or(isZero).test(0));
        System.out.println("or(isZero).test(0) = " + isPositive.or(isZero).test(1));
        System.out.println("or(isZero).test(0) = " + isPositive.or(isZero).test(-1));
        // false || -1 > 0
        System.out.println("and(isFalse).test(-1) = " + isPositive.and(isFalse).test(-1));

        // "Hero".equals("Hero");
        System.out.println("\"Hero\".equals(\"Hero\") : " + equalString.test("Hero"));

        //!(-3 > 0)
        final Predicate<Integer> not = Predicate.not(isPositive);
        System.out.println("!(-3 > 0) : " + not.test(-3));

        List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
        final Predicate<Integer> nGraterThan3 = n -> n > -3;
        final Predicate<Integer> nLessThan3 = n -> n < 3;

        numbers.stream().filter(nGraterThan3.and(nLessThan3)).forEach(n -> System.out.println("-3 < numbers < 3 : " + n));

    }


}



