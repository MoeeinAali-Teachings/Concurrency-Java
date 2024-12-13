package threadSafe;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    private static ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    map.put(i, "Value-" + i);
                    System.out.println("Thread 1 added: " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 10; i < 20; i++) {
                    map.put(i, "Value-" + i);
                    System.out.println("Thread 2 added: " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    String value = map.get(i);
                    System.out.println("Thread 3 read: " + i + " = " + value);
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final contents of ConcurrentHashMap: " + map);
    }
}
