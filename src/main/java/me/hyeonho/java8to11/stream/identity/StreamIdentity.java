package me.hyeonho.java8to11.stream.identity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StreamIdentity {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(mapOld(numbers, i -> i*2));
        System.out.println(mapOld(numbers,null));

        System.out.println(map(numbers, i -> i*2));
        System.out.println(map(numbers, Function.identity())); // identity 사용하

    }
    private static <T,R> List<R> map(final List<T> list,final Function<T,R> mapper){
        final List<R> result = new ArrayList<>();

        for (final T t : list ){
            result.add(mapper.apply(t));
        }
        return result;
    }
    private static <T,R> List<R> mapOld(final List<T> list,final Function<T,R> mapper){
        final List<R> result;
        if (mapper != null){
            result = new ArrayList<>();
        }else {
            result = new ArrayList<>((List<R>)list);
        }

        if (result.isEmpty()){
            for (final T t : list) {
                result.add(mapper.apply(t));
            }
        }

        return result;
    }

}

