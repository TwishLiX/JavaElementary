package homework19_logger;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        byte action;
        do {
            try {
                System.out.println("1 - Start a new game");
                System.out.println("2 - Exit");
                System.out.print("\nChoose a task to run: ");
                action = scanner.nextByte();
                switch (action) {
                    case 1 -> new Game().startGame();
                    case 2 -> System.exit(0);
                    default -> System.err.println("Incorrect value.\n");
                }
            } catch (InputMismatchException e) {
                System.err.println("Incorrect value.\n");
                scanner.nextLine();
                continue;
            }
            System.out.println();
        } while (true);
    }
}
