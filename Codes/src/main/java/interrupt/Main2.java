package interrupt;

public class Main2 {

    static class LongRunningTask extends Thread {
        @Override
        public void run() {
            System.out.println("ترد شروع به انجام کاری طولانی می‌کند...");
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                    System.out.println("کار در حال انجام است... مرحله " + (++i));
                } catch (InterruptedException e) {
                    System.out.println("ترد متوقف شد (قطع شد).");
                    return;
                }
            }
            System.out.println("ترد متوقف شد (با بررسی `isInterrupted`)...");
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
