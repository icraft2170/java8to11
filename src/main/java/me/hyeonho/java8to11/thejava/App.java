package me.hyeonho.java8to11.thejava;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(1000L);
            return "Hello!";
        };
        Callable<String> java = () -> {
            Thread.sleep(2000L);
            return "java!";
        };
        Callable<String> monster = () -> {
            Thread.sleep(3000L);
            return "monster!";
        };

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, monster));
        futures.forEach(stringFuture -> {
            try {
                System.out.println(stringFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }

    private static Runnable getRunnable(String str) {
        return () -> System.out.println("Thread submit " + str);
    }
}

