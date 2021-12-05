package me.hyeonho.java8to11.modern.custom;


public class FunctionalInterfaceCustomExamples {

    public static void main(String[] args) {
        println("Area is ",12,20,(message, length, width) -> message + (length * width));
        println(1L,"Hyeonho","test@email.com"
                ,(id, name, email) -> "User info : ID : " + id + " NAME : " + name + " Email : " + email);
    }


    private static <T1,T2,T3> void println(T1 t1, T2 t2, T3 t3, Function3<T1, T2, T3, String> function){
        System.out.println(function.apply(t1,t2,t3));
    }

}

@FunctionalInterface
interface Function3<T1,T2,T3,R>{
    R apply(T1 t1, T2 t2, T3 t3);
}
