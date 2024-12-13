package interrupt;

public class Main {

    static class LongRunningTask extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("ترد شروع به انجام کاری طولانی می‌کند...");
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    System.out.println("کار در حال انجام است... مرحله " + (i + 1));
                }
            } catch (InterruptedException e) {
                System.out.println("ترد متوقف شد (قطع شد).");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LongRunningTask longRunningTask = new LongRunningTask();

        longRunningTask.start();

        Thread.sleep(3000);

        System.out.println("درخواست قطع ترد...");
        longRunningTask.interrupt();

        longRunningTask.join();

        System.out.println("تمام شد.");
    }
}
