package pr4;

public class Test {

    public static void main(String[] args) {
        MyExecutorService executorService = new MyExecutorService(4);
        executorService.execute(() -> System.out.println("1"));
        executorService.execute(() -> System.out.println("2"));
        executorService.execute(() -> System.out.println("3"));
        executorService.execute(() -> System.out.println("4"));
        executorService.execute(() -> System.out.println("5"));
        executorService.execute(() -> System.out.println("6"));
        executorService.shutdown();
    }
}
