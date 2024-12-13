package reentrantReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    private static ReadWriteLock lock = new ReentrantReadWriteLock();
    private static int sharedData = 0;

    public static void main(String[] args) {

        Thread reader1 = new Thread(() -> {
            try {
                lock.readLock().lock();
                System.out.println("Reader 1: Reading data: " + sharedData);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }
        });

        Thread reader2 = new Thread(() -> {
            try {
                lock.readLock().lock();
                System.out.println("Reader 2: Reading data: " + sharedData);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }
        });

        Thread writer = new Thread(() -> {
            try {
                lock.writeLock().lock();
                System.out.println("Writer: Writing data...");
                sharedData = 42;
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
        });

        reader1.start();
        reader2.start();
        writer.start();

        try {
            reader1.join();
            reader2.join();
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final data value: " + sharedData);
    }
}
