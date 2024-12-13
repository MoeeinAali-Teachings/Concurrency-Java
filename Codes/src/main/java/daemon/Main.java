package daemon;

class MyDaemonThread implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Daemon thread is running...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Daemon thread interrupted.");
        } finally {
            System.out.println("Daemon thread exiting.");
        }
    }
}

class MyUserThread implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("User thread is running... Count: " + i);
                Thread.sleep(2000);
            }
            System.out.println("User thread has finished.");
        } catch (InterruptedException e) {
            System.out.println("User thread interrupted.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(new MyDaemonThread());
        daemonThread.setDaemon(true);
        daemonThread.start();

        Thread userThread = new Thread(new MyUserThread());
        userThread.start();

        System.out.println("Main thread is exiting.");
    }
}
