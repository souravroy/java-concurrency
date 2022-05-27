package executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceRunnable {
    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(3);

        Future future = executorService.submit(getRunnable("Task 1.1"));

        System.out.println(future.isDone());

        try {
            future.get();
        } catch (InterruptedException | ExecutionException ie) {
            System.out.println(ie);
        }

        System.out.println(future.isDone());

        executorService.shutdown();
    }

    public static Runnable getRunnable(String msg) {
        return () -> {
            String message = Thread.currentThread().getName() +
                    " : " + msg;
            System.out.println(message);
        };
    }
}
