package homework16_parser;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String directory;
        byte action;
        if (args.length == 0) directory = System.getProperty("user.dir");
        else directory = args[0];
        do {
            try {
                System.out.println("Choose a conversion method:");
                System.out.println("1 - Json -> Yaml");
                System.out.println("2 - Yaml -> Json");
                System.out.println("0 - Exit");
                System.out.print("Input: ");
                action = scanner.nextByte();
                switch (action) {
                    case 1 -> Converter.convert(directory, ".json");
                    case 2 -> Converter.convert(directory, ".yaml");
                    case 0 -> System.exit(0);
                    default -> System.out.println("Incorrect value.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect value.\n");
                scanner.nextLine();
                continue;
            }
            System.out.println();
        } while (true);
    }
}
