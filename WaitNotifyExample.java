class Counter {
    private int count = 0;
    private boolean canIncrement = true;

    public synchronized void increment() throws InterruptedException {
        while (!canIncrement) {
            wait(); // 다른 스레드가 작업을 완료할 때까지 대기
        }
        count++;
        System.out.println("Incremented: " + count);
        canIncrement = false; // 다른 스레드가 작업할 수 있도록 플래그 변경
        notifyAll(); // 대기 중인 모든 스레드에게 알림
    }

    public synchronized void decrement() throws InterruptedException {
        while (canIncrement) {
            wait(); // 다른 스레드가 작업을 완료할 때까지 대기
        }
        count--;
        System.out.println("Decremented: " + count);
        canIncrement = true; // 다른 스레드가 작업할 수 있도록 플래그 변경
        notifyAll(); // 대기 중인 모든 스레드에게 알림
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    counter.increment();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    counter.decrement();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();
        t2.start();
    }
}
