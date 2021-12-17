package me.hyeonho.java8to11.morder_java_in_action.appd;

import java.util.function.Function;

public class Lambda {
    Function<Object, String> f = obj -> obj.toString();
}
