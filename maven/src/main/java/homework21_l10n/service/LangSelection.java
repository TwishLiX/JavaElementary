package homework21_l10n.service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LangSelection {

    public static ResourceBundle select(ResourceBundle resourceBundle) throws UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);
        String lang;
        do {
            System.out.print(new String(resourceBundle.getString("langSelectionMenu")
                    .getBytes(StandardCharsets.ISO_8859_1), "windows-1251"));
            lang = scanner.nextLine();
            if (!lang.equals("en") && !lang.equals("ru") && !lang.equals("uk")) {
                System.err.println(new String(resourceBundle.getString("incorrectInput")
                        .getBytes(StandardCharsets.ISO_8859_1), "windows-1251"));
            } else {
                System.out.println();
                return ResourceBundle.getBundle("messages", new Locale(lang));
            }
        } while (true);
    }
}
