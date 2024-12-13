package waitNotify;

import java.util.LinkedList;
import java.util.Queue;

class ProducerConsumer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private static final int MAX_CAPACITY = 5;
    private static final int TOTAL_ITEMS = 10;

    public synchronized void produce() throws InterruptedException {
        for (int i = 0; i < TOTAL_ITEMS; i++) {
            while (buffer.size() == MAX_CAPACITY) {
                System.out.println("بافر پر است، تولیدکننده منتظر می‌ماند...");
                wait();
            }

            buffer.add(i);
            System.out.println("تولیدکننده: " + i);

            notify();

            Thread.sleep(500);
        }
    }

    public synchronized void consume() throws InterruptedException {
        for (int i = 0; i < TOTAL_ITEMS; i++) {
            while (buffer.isEmpty()) {
                System.out.println("بافر خالی است، مصرف‌کننده منتظر می‌ماند...");
                wait();
            }

            int item = buffer.poll();
            System.out.println("مصرف‌کننده: " + item);

            notify();

            Thread.sleep(1000);
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("تمام شد.");
    }
}
