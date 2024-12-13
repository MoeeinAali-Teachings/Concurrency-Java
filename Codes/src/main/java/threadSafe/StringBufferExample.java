package threadSafe;

public class StringBufferExample {

    // ایجاد یک StringBuffer مشترک
    private final static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sb.append("A");
                System.out.println("Thread 1: Added A");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sb.append("B");
                System.out.println("Thread 2: Added B");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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

        System.out.println("Final StringBuffer content: " + sb.toString());
    }
}
