package atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExample {
    private static AtomicReference<String> reference = new AtomicReference<>("Initial Value");

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            reference.compareAndSet("Initial Value", "Updated by Thread 1");
            System.out.println("Thread 1 updated value: " + reference.get());
        });

        Thread thread2 = new Thread(() -> {
            reference.compareAndSet("Initial Value", "Updated by Thread 2");
            System.out.println("Thread 2 updated value: " + reference.get());
        });

        thread1.start();
        thread2.start();
    }
}
