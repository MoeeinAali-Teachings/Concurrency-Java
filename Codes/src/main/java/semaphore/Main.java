package semaphore;

import java.util.concurrent.Semaphore;

public class Main {

    private final static int MAX_THREADS = 3;
    private static Semaphore semaphore = new Semaphore(MAX_THREADS);

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Thread 1: Accessing resource");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("Thread 1: Released resource");
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Thread 2: Accessing resource");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("Thread 2: Released resource");
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Thread 3: Accessing resource");
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("Thread 3: Released resource");
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Thread 4: Accessing resource");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("Thread 4: Released resource");
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

