import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTests {
    private static boolean lock;

    private static synchronized void add(List<String> items, String item) {
        items.add(item);
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> items = new ArrayList<>();

        //ArrayList<>();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    items.add("A");
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

        System.out.println("items.size() = " + items.size());
    }
}
