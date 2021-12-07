package me.hyeonho.java8to11.thejava;

import java.util.Locale;

public interface Foo {
    void printName();

    default void printNameUpperCase(){
        System.out.println(strFoo().toUpperCase());
    };

    private String strFoo(){
        return "foo";
    }

}
