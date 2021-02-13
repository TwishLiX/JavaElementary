package homework21_l10n;

import homework21_l10n.service.Game;
import homework21_l10n.service.LangSelection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ResourceBundle resourceBundle = LangSelection.select(ResourceBundle.getBundle("messages", new Locale("en")));
        byte action;
        do {
            try {
                System.out.print(new String(resourceBundle.getString("mainMenu")
                        .getBytes(StandardCharsets.ISO_8859_1), "windows-1251"));
                action = scanner.nextByte();
                switch (action) {
                    case 1 -> new Game(resourceBundle).startGame();
                    case 2 -> {
                        System.out.println();
                        resourceBundle = LangSelection.select(resourceBundle);
                    }
                    case 3 -> System.exit(0);
                    default -> System.err.println(new String(resourceBundle.getString("incorrectInput")
                            .getBytes(StandardCharsets.ISO_8859_1), "windows-1251"));
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.err.println(new String(resourceBundle.getString("incorrectInput")
                        .getBytes(StandardCharsets.ISO_8859_1), "windows-1251"));
            }
        } while (true);
    }
}
