package deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Runnable1 runnable1 = new Runnable1(lock1, lock2);
        Runnable2 runnable2 = new Runnable2(lock1, lock2);

        /*new Thread(runnable1).start();
        new Thread(runnable2).start();*/

        RunnableSync1 runnableSync1 = new RunnableSync1(lock1, lock2);
        RunnableSync2 runnableSync2 = new RunnableSync2(lock1, lock2);

        new Thread(runnableSync1).start();
        new Thread(runnableSync2).start();
    }
}
