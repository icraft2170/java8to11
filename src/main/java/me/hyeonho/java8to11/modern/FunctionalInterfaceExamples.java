package me.hyeonho.java8to11.modern;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 */
public class FunctionalInterfaceExamples {

    public static void main(String[] args) {

        // Anonymous Inner Class
        final Function<String, Integer> toInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };

        final Integer number = toInt.apply("11");
        System.out.println("toInt " + (number instanceof Integer)); // true

        // Lambda Expression
        final Function<String, Integer> toIntWithLambda = value -> Integer.parseInt(value);
        /**
         * (value) -> {
         *      return Integer.parseInt(value);
         * };
         */

        Integer number2 = toIntWithLambda.apply("22");
        System.out.println("toIntWithLambda : " + (number2 instanceof Integer)); // true

        // identity Function
        final Function<Integer, Integer> identity = Function.identity();
        System.out.println("identity : " + identity.apply(100));

        // Function compose
        System.out.println("toInt(before) compose identity(after) : " +  identity.compose(toInt).apply("10"));

        // Function andThen
        System.out.println("identity(after) andThen toInt(before) : " +  toInt.andThen(identity).apply("10"));

        System.out.println("==================================================================");


        // Anonymous Inner Class
        final Consumer<String> printWithInnerClass = new Consumer<String>() {
            @Override
            public void accept(String value) {
                System.out.println(value);
            }
        };

        // Lambda Expression
        final Consumer<String> printWithLambda = value -> System.out.println("Hi " + value);

        printWithInnerClass.accept("Hello i'm Hero");
        printWithLambda.accept("Hero");

        printWithInnerClass.andThen(printWithLambda).accept("Hero(andThen)");
        System.out.println("==================================================================");

        final Predicate<Integer> isPositive = i -> i > 0;
        final Predicate<Integer> isZero = i -> i == 0;
        final Predicate<Integer> isFalse = i -> false;
        final Predicate<String> equalString = Predicate.<String>isEqual("Hero");

        System.out.println("test(1) :" + isPositive.test(1));
        System.out.println("test(-1) :" +isPositive.test(-1));
        System.out.println("negate().test(-1):" +isPositive.negate().test(-1));

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
        final Predicate<Integer> nGraterThan3 =  n -> n > -3;
        final Predicate<Integer> nLessThan3 =  n -> n < 3;

        numbers.stream().filter(nGraterThan3.and(nLessThan3)).forEach(n -> System.out.println("-3 < numbers < 3 : " + n));

        System.out.println("==================================================================");

        String veryExpensiveValue = " aaa " + " bbb " + " ccc " + "";
        System.out.println("veryExpensiveValue : " + veryExpensiveValue);

        Supplier<String> content = () -> " aaa " + " bbb " + " ccc " + "";
        print(1,content); //content에 문자열 연산을 한다
        print(-1,content); //content에 문자열 연산을 하지 않는다.

    }

    private static void print(int number ,Supplier supplier) {
        if(number > 0){
            System.out.println("supplier : " + supplier.get());
        }else if(number < 0){
            System.out.println("negative");
        }
    }
}
