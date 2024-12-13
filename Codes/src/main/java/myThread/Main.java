package myThread;

import java.util.Scanner;

class MyThread extends Thread {
    private int sleepTime; // مدت زمان خواب (بر حسب میلی‌ثانیه)

    // سازنده برای دریافت مدت زمان خواب
    public MyThread(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        System.out.println("MyThread is running. Sleeping for " + sleepTime + " milliseconds.");
        try {
            // نخ را به مدت مشخص شده به خواب می‌بریم
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        }
        System.out.println("MyThread has finished.");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread(1000);
        MyThread thread2 = new MyThread(2000);
        thread1.start();
        thread2.start();
    }
}
