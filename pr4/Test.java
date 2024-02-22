package pr4;


public class Test {

    public static void main(String[] args) throws InterruptedException {
        MyExecutorService executorService = new MyExecutorService(2);

        executorService.execute(() -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            System.out.println("Sum: " + sum);
        });

        executorService.execute(() -> {
            int sum = 0;
            for (int i = 1; i <= 1000; i++) {
                sum += i;
            }
            System.out.println("Sum: " + sum);
        });
        Thread.sleep(100);
        executorService.execute(() -> {
            int sum = 0;
            for (int i = 1; i <= 10000; i++) {
                sum += i;
            }
            System.out.println("Sum: " + sum);
        });
        executorService.shutdown();
    }

}
