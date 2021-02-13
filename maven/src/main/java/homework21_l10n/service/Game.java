package homework21_l10n.service;

import homework21_l10n.dto.Move;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Game {
    private static final Move[] moves = {Move.ROCK, Move.SCISSORS, Move.PAPER};
    private static final Logger logger = LoggerFactory.getLogger(Game.class);

    public void startGame(ResourceBundle resourceBundle) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String nickname;
        String result;
        byte userMove = 0;
        byte computerMove;
        short rounds = 0;
        short drawsCounter = 0;
        short userWinsCounter = 0;
        short computerWinsCounter = 0;
        System.out.println(new String(resourceBundle.getString("welcomeSign")
                .getBytes(StandardCharsets.ISO_8859_1), "windows-1251"));
        System.out.print(new String(resourceBundle.getString("nicknameInput")
                .getBytes(StandardCharsets.ISO_8859_1), "windows-1251"));
        nickname = scanner.next();
        logger.info("Player {} entered the game.", nickname);
        do {
            try {
                System.out.print(new String(resourceBundle.getString("roundsInput")
                        .getBytes(StandardCharsets.ISO_8859_1), "windows-1251"));
                rounds = scanner.nextShort();
            } catch (InputMismatchException e) {
                logger.error("Value is not a number.");
                System.err.println(new String(resourceBundle.getString("notANumber")
                        .getBytes(StandardCharsets.ISO_8859_1), "windows-1251"));
                scanner.nextLine();
                continue;
            }
            if (rounds <= 0) {
                logger.error("Value is negative.");
                System.err.println(new String(resourceBundle.getString("positiveQuantity")
                        .getBytes(StandardCharsets.ISO_8859_1), "windows-1251"));
            }
        } while (rounds <= 0);
        logger.info("Player {} chose {} games", nickname, rounds);
        System.out.println(new String(resourceBundle.getString("rules")
                .getBytes(StandardCharsets.ISO_8859_1), "windows-1251"));
        scanner.nextLine();
        for (int i = 0; i < rounds; i++) {
            System.out.println(new String(resourceBundle.getString("gameNumber")
                    .getBytes(StandardCharsets.ISO_8859_1), "windows-1251") + (i + 1));
            do {
                try {
                    System.out.print(new String(resourceBundle.getString("moveSelection")
                            .getBytes(StandardCharsets.ISO_8859_1), "windows-1251"));
                    userMove = scanner.nextByte();
                } catch (InputMismatchException e) {
                    logger.error("Value is not a number.");
                    System.err.println(new String(resourceBundle.getString("notANumber")
                            .getBytes(StandardCharsets.ISO_8859_1),"windows-1251"));
                    scanner.nextLine();
                }
            } while (userMove != 0 && userMove != 1 && userMove != 2 && userMove != 3);
            if (userMove == 0) {
                logger.info("Player {} interrupted the game.", nickname);
                System.out.println();
                return;
            }
            logger.info("{} chose {}", nickname, getPlayerChoice((byte) (userMove - 1)));
            System.out.println(nickname + " -> " + getPlayerChoice((byte) (userMove - 1)));
            computerMove = (byte) (Math.random() * 3);
            logger.info("Computer chose {}", getComputerChoice(computerMove));
            System.out.println(new String(resourceBundle.getString("computer")
                    .getBytes(StandardCharsets.ISO_8859_1), "windows-1251") +
                    " -> " + getComputerChoice(computerMove));
            result = getWinner(computerMove, (byte) (userMove - 1), nickname);
            if (result.equals("Draw")) {
                System.out.println(new String(resourceBundle.getString("draw")
                        .getBytes(StandardCharsets.ISO_8859_1), "windows-1251"));
                drawsCounter++;
            } else if (result.equals("Computer")) {
                System.out.println(new String(resourceBundle.getString("computer")
                        .getBytes(StandardCharsets.ISO_8859_1), "windows-1251") +
                        " " + new String(resourceBundle.getString("won")
                        .getBytes(StandardCharsets.ISO_8859_1), "windows-1251"));
                computerWinsCounter++;
            } else {
                System.out.println(result + " " + new String(resourceBundle.getString("won")
                        .getBytes(StandardCharsets.ISO_8859_1), "windows-1251"));
                userWinsCounter++;
            }
            logger.info("Winner: {}. {} game(s) have been played, {} games left.",
                    result, (i + 1), rounds - (i + 1));
        }
        logger.info("Player {} finished the game.", nickname);
        System.out.println();
        String log = "===============================\n" + new String(resourceBundle.getString("amountOfRounds")
                .getBytes(StandardCharsets.ISO_8859_1), "windows-1251") + ": " + rounds +
                "\n-------------" + new String(resourceBundle.getString("score")
                .getBytes(StandardCharsets.ISO_8859_1), "windows-1251") +
                "-------------\n" + new String(resourceBundle.getString("draws")
                .getBytes(StandardCharsets.ISO_8859_1), "windows-1251") +
                ": " + drawsCounter + "; " + new String(resourceBundle.getString("computer")
                .getBytes(StandardCharsets.ISO_8859_1), "windows-1251") +
                ": " + computerWinsCounter + "; " + nickname + ": " +
                userWinsCounter + "\n===============================\n\n";
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
