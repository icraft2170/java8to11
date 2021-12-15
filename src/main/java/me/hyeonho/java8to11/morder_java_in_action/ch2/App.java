package me.hyeonho.java8to11.morder_java_in_action.ch2;

import java.util.Comparator;
import java.util.concurrent.Callable;

public class App {
    public static int a = 0;
    public int b;
    public static void main(String[] args) {

        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                a = i;
                System.out.println(a);
            }
        });


        Thread t2 = new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                a = i;
                System.out.println(a);
            }
        });

        App app = new App();
        app.run();

//        t1.start();
//        t2.start();
    }

    public void run(){
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                b = i;
                System.out.println(b);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread t2 = new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                b = i;
                System.out.println(b);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t1.run();
        t2.run();
    }
}
