package me.hyeonho.java8to11.modern.consumer;

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
public class FunctionalInterfaceConsumerExample {


    public static void main(String[] args) {
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
    }


}
