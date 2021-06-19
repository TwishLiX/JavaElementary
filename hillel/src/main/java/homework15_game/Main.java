package homework15_game;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int action;
        do {
            try {
                System.out.println("1 - Start a new game");
                System.out.println("2 - Exit");
                System.out.print("\nChoose a task to run: ");
                action = scanner.nextInt();
                switch (action) {
                    case 1 -> new Game().startGame();
                    case 2 -> System.exit(0);
                    default -> System.out.println("Incorrect value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Value is not a number.");
                scanner.nextLine();
            }
        } while (true);
    }
}
