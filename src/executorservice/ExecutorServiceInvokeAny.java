package executorservice;

import java.util.concurrent.*;
import java.util.*;

public class ExecutorServiceInvokeAny {

    public static void main(String[] args) {

        ExecutorService executorService =
                Executors.newFixedThreadPool(3);

        List<Callable<String>> callables = new ArrayList<>();
        callables.add(getCallables("Task 1.1"));
        callables.add(getCallables("Task 1.2"));
        callables.add(getCallables("Task 1.3"));

        try {
            String result = executorService.invokeAny(callables);
            System.out.println(result);
        } catch (InterruptedException | ExecutionException ie) {
            System.out.println(ie);
        }

        executorService.shutdown();
    }

    public static Callable<String> getCallables(String msg) {
        return () -> Thread.currentThread().getName() +" : " + msg;
    }
}
