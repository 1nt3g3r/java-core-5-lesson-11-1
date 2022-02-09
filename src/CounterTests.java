import java.util.ArrayList;
import java.util.List;

public class CounterTests {
    private static volatile Counter counter = new Counter(0);

    public static synchronized void increment() {
        counter = counter.increment();
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    increment();
                }
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(counter);
    }
}
