package deadlock;

public class RunnableSync2 implements Runnable{
    Object lock1 = null;
    Object lock2 = null;

    public RunnableSync2(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " attempting to lock lock2");
        synchronized(lock2) {
            System.out.println(threadName + " locked lock2");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ie) {
                // ignore
            }

            System.out.println(threadName + " attempting to lock lock1");
            synchronized(lock1) {
                System.out.println(threadName + " locked lock1");
                // do the work - now that both locks have been acquired.

            }
            System.out.println(threadName + " unlocking lock1");
        }
        System.out.println(threadName + " unlocking lock2");
    }
}
