package priority;


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
            System.out.println("Sleeping...");
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        }
        System.out.println(finalText);
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable(1000, "thread1 finished"));
        System.out.println(thread.getName());
        System.out.println(thread.getId());
        System.out.println(thread.getState());
        
        thread.start();
        System.out.println(thread.getState());
    }
}
