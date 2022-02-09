public class ThreadSleepTests {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");

        new Thread(() -> {
            System.out.println("In new thread");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End in new thread");
        }).start();

        Thread.sleep(1000);
        System.out.println("End");
    }
}
