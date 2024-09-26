class MyThread extends Thread {
    @Override
    public void run() {
        // 스레드가 수행할 작업
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + " - Count: " + i);
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start(); // 스레드 시작
        thread2.start(); // 스레드 시작
    }
}
