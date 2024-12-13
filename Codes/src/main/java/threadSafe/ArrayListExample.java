package threadSafe;

import java.util.ArrayList;
import java.util.List;

class ArrayListExample {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    list.add(i);
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
                    list.add(i);
                    System.out.println("Thread 2 added: " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final contents of ArrayList: " + list);
    }
}
