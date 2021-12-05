
package me.hyeonho.java8to11.modern.function;

import java.util.function.Function;


/**
 *
 */
public class FunctionalInterfaceFunctionExample {

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
    }


}

