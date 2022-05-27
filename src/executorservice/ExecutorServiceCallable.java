package executorservice;

import java.util.concurrent.*;

public class ExecutorServiceCallable {

    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(3);

        Future future = executorService.submit(getCallable("Task 1.1"));

        System.out.println(future.isDone());

        try {
            String  message = (String) future.get();
            System.out.println(message);
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex);
        }

        System.out.println(future.isDone());

        executorService.shutdown();
    }

    public static Callable getCallable(String msg) {
        return () -> Thread.currentThread().getName() + " : " + msg;
    }
}
