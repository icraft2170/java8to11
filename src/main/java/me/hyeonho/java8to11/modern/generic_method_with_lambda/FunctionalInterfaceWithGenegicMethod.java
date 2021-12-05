package me.hyeonho.java8to11.modern.generic_method_with_lambda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 */
public class FunctionalInterfaceWithGenegicMethod {

    public static void main(String[] args) {
        final BigDecimalToCurrency bigDecimalToCurrency = bd -> "$" + bd.toString();
        System.out.println(bigDecimalToCurrency.toCurrency(new BigDecimal("120.00")));

        final InvalidFunctionalInterface anonymousClass = new InvalidFunctionalInterface() {
            @Override
            public <T> String mkCurrency(T value) {
                return "$" + value.toString();
            }
        };
        System.out.println(anonymousClass.mkCurrency(123));

        // 컴파일 에러
        //final InvalidFunctionalInterface invalidFunctionalInterface = value -> "$ " + value.toString();
        //System.out.println(invalidFunctionalInterface.mkCurrency(123));
    }


}

@FunctionalInterface
interface BigDecimalToCurrency{
    String toCurrency(BigDecimal value);
}

@FunctionalInterface
interface InvalidFunctionalInterface{
    <T> String mkCurrency(T value);
}

