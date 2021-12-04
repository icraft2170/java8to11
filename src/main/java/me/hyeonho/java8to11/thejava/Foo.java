package me.hyeonho.java8to11.thejava;

public interface Foo {
    void printName();

    default void printNameUpperCase(){
        System.out.println("FOO");
    };
}
