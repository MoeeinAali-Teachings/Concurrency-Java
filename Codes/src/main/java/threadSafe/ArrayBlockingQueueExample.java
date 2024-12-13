package threadSafe;

import java.util.concurrent.ArrayBlockingQueue;

class ArrayBlockingQueueExample {

    private static final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 20; i++) {
                        queue.put(i);
                        System.out.println("Produced: " + i);
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 20; i++) {
                        Integer item = queue.take();
                        System.out.println("Consumed: " + item);
                        Thread.sleep(150);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
