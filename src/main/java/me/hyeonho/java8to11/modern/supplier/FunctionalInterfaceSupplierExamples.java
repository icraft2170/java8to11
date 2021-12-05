package me.hyeonho.java8to11.modern.supplier;

import java.util.function.Supplier;

/**
 *
 */
public class FunctionalInterfaceSupplierExamples {

    public static void main(String[] args) {
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
