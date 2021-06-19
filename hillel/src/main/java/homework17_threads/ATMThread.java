package homework17_threads;

import java.util.Random;

public class ATMThread extends Thread {

    @Override
    public void run() {
        synchronized (ATM.class) {
            for (int i = 0; i < 50; i++) {
                boolean isReplenishment = new Random().nextBoolean();
                int sum = 10 + new Random().nextInt(1001) * 10;
                if (isReplenishment) {
                    ATM.replenish(sum);
                    System.out.println(Thread.currentThread().getName() + ": replenishment, " + sum
                            + "$. ATM balance: " + ATM.getBalance() + "$");
                } else {
                    if (sum > ATM.getBalance()) {
                        System.err.println("Cannot withdraw cash. Withdrawal sum: "
                                + sum + ", ATM balance: " + ATM.getBalance());
                    } else {
                        ATM.withdraw(sum);
                        System.out.println(Thread.currentThread().getName() + ": withdrawal, " + sum
                                + "$. ATM balance: " + ATM.getBalance() + "$");
                    }
                }
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
