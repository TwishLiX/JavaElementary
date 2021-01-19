package homework17_threads;

public class Main {

    public static void main(String[] args) {
        ATMThread thread1 = new ATMThread();
        ATMThread thread2 = new ATMThread();
        ATMThread thread3 = new ATMThread();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
