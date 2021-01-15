package homework15_game;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private static final Move[] moves = {Move.ROCK, Move.SCISSORS, Move.PAPER};

    public void startGame() throws IOException {
        Scanner scanner = new Scanner(System.in);
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
            System.out.println(nickname + " -> " + getPlayerChoice((byte) (userMove - 1)));
            computerMove = (byte) (Math.random() * 3);
            System.out.println("Computer -> " + getComputerChoice(computerMove));
            result = getWinner(computerMove, (byte) (userMove - 1), nickname);
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
        new DataWriting().writeToFile(log);
    }

    private Move getPlayerChoice(byte userMove) {
        return moves[userMove];
    }

    private Move getComputerChoice(byte computerMove) {
        return moves[computerMove];
    }

    private String getWinner(byte computerMove, byte userMove, String nickname) {
        String[][] winnerMatrix = {{"Draw", "Computer", nickname}, {nickname, "Draw", "Computer"}, {"Computer", nickname, "Draw"}};
        return winnerMatrix[computerMove][userMove];
    }
}
