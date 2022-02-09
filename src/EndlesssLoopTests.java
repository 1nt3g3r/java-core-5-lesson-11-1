public class EndlesssLoopTests {

    public static void main(String[] args) {
        printThreadName();

        for (int i = 0; i < 100; i++) {
            new Thread(EndlesssLoopTests::printThreadName).start();
        }
    }


    private static void printThreadName() {
        System.out.println(
                "Thread.currentThread().getName() = " +
                        Thread.currentThread().getName()
        );
    }
}
