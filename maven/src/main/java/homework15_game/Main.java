package homework15_game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int action;
        do {
            try {
                System.out.println("1 - Start a new game");
                System.out.println("2 - Exit");
                System.out.print("\nChoose a task to run: ");
                action = scanner.nextInt();
                switch (action) {
                    case 1 -> main.startGame();
                    case 2 -> System.exit(0);
                    default -> System.out.println("Incorrect!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Value is not a number.");
                scanner.nextLine();
            }
        } while (true);
    }

    public void startGame() throws IOException {
        Move[] moves = {Move.ROCK, Move.SCISSORS, Move.PAPER};
        String nickname;
        String result;
        byte userMove = 0;
        byte computerMove;
        short rounds = 0;
        short drawsCounter = 0;
        short userWinsCounter = 0;
        short computerWinsCounter = 0;
        System.out.println("Welcome to the rock-paper-scissors game!");
        System.out.print("Input your nickname: ");
        nickname = scanner.next();
        do {
            try {
                System.out.print("Input a quantity of rounds: ");
                rounds = scanner.nextShort();
            } catch (InputMismatchException e) {
                System.out.println("Value is not a number.");
                scanner.nextLine();
                continue;
            }
            if (rounds <= 0) {
                System.out.println("Quantity of games must be positive.");
            }
        } while (rounds <= 0);
        System.out.println("In each round you will have to choose your move:");
        System.out.println("1 - Rock\n2 - Paper\n3 - Scissors");
        System.out.println("To interrupt the game, input \"0\".");
        scanner.nextLine();
        for (int i = 0; i < rounds; i++) {
            System.out.println("\nGame #" + (i + 1));
            do {
                try {
                    System.out.print("Choose your move: ");
                    userMove = scanner.nextByte();
                } catch (InputMismatchException e) {
                    System.out.println("Value is not a number.");
                    scanner.nextLine();
                }
            } while (userMove != 0 && userMove != 1 && userMove != 2 && userMove != 3);
            if (userMove == 0) {
                System.out.println();
                return;
            }
            System.out.println(nickname + " -> " + moves[userMove - 1]);
            computerMove = (byte) (Math.random() * 3);
            System.out.println("Computer -> " + moves[computerMove]);
            result = winnerChecker(computerMove, (byte) (userMove - 1), nickname);
            if (result.equals("Draw")) {
                System.out.println(result);
                drawsCounter++;
            } else if (result.equals("Computer")) {
                System.out.println(result + " won!");
                computerWinsCounter++;
            } else {
                System.out.println(result + " won!");
                userWinsCounter++;
            }
        }
        System.out.println();
        String log = "===============================\nAmount of rounds: " + rounds +
                "\n-------------Score-------------\nDraws: " + drawsCounter +
                "; Computer: " + computerWinsCounter + "; " + nickname +
                ": " + userWinsCounter + "\n===============================\n\n";
        System.out.println(log);
        writeToFile(log);
    }

    private String winnerChecker(byte computerMove, byte userMove, String nickname) {
        String[][] winnerMatrix = {{"Draw", "Computer", nickname}, {nickname, "Draw", "Computer"}, {"Computer", nickname, "Draw"}};
        return winnerMatrix[computerMove][userMove];
    }

    private void writeToFile(String log) throws IOException {
        String appDirectory = FileSystems.getDefault()
                .getPath("E:\\! Gallery\\Documents\\Hillel IT School\\Java Elementary\\maven\\src\\main\\java\\homework15_game\\game_log.txt")
                .toAbsolutePath()
                .toString();
        File file = new File(appDirectory);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(log);
        writer.close();
    }
}
