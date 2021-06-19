package homework17_threads;

public class ATM {
    private static long balance;

    public static void setBalance(int balance) {
        ATM.balance = balance;
    }

    public static long getBalance() {
        return balance;
    }

    public static void withdraw(int sum) {
        setBalance((int) (balance -= sum));
    }

    public static void replenish(int sum) {
        setBalance((int) (balance += sum));
    }
}
