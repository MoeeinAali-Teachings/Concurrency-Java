package atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanExample {
    private static AtomicBoolean flag = new AtomicBoolean(false);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            if (flag.compareAndSet(false, true)) {
                System.out.println("Thread 1: Flag set to true");
            }
        });

        Thread thread2 = new Thread(() -> {
            if (flag.compareAndSet(false, true)) {
                System.out.println("Thread 2: Flag set to true");
            } else {
                System.out.println("Thread 2: Flag was already set to true");
            }
        });

        thread1.start();
        thread2.start();
    }
}
