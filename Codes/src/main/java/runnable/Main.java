package runnable;


class MyRunnable implements Runnable {
    private int sleepTime;
    private String finalText;

    public MyRunnable(int sleepTime, String finalText) {
        this.sleepTime = sleepTime;
        this.finalText = finalText;
    }

    @Override
    public void run() {
        System.out.println("MyRunnable is running. Sleeping for " + sleepTime + " milliseconds.");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        }
        System.out.println(finalText);
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable(1000, "thread1 finished"));
        Thread thread2 = new Thread(new MyRunnable(1000, "thread2 finished"));
        thread1.start();
        thread2.start();
    }
}
