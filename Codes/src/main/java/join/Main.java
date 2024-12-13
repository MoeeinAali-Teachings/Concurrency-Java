package join;

class MyThread extends Thread {
    private String message;

    MyThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("ترد 1");
        MyThread t2 = new MyThread("ترد 2");
        MyThread t3 = new MyThread("ترد 3");

        t1.start();

        try {
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("تمام تردها تمام شدند.");
    }
}
