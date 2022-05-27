package deadlock;

import java.util.concurrent.locks.Lock;

public class Runnable1 implements Runnable {

    private Lock lock1 = null;
    private Lock lock2 = null;

    public Runnable1(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " Attempting to lock lock1");
        lock1.lock();
        System.out.println(threadName + " Locked lock1");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
            // ignore
        }

        System.out.println(threadName + " Attempting to lock lock2");
        lock2.lock();
        System.out.println(threadName + " Locked lock2");

        // do the work - now that both locks have been acquired (lock1, lock2)

        // Unlock
        System.out.println(threadName + " Unlocking lock1");
        lock1.unlock();
        System.out.println(threadName + " Unlocking lock2");
        lock2.unlock();
    }
}
