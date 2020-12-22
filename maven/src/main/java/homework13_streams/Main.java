package homework13_streams;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        int action;
        System.out.println("1 - Find an average of numbers.");
        System.out.println("2 - Bring strings to upper case.");
        System.out.println("3 - Filter strings by parameters.");
        System.out.println("0 - Exit.");
        do {
            System.out.print("Choose a task to run: ");
            action = scanner.nextInt();
            switch (action) {
                case 1 -> main.getAverage();
                case 2 -> main.getUpperCase();
                case 3 -> main.filterByParameters();
                case 0 -> System.exit(0);
                default -> System.out.println("Incorrect!");
            }
        } while (true);
    }

    public void getAverage() {
        List<Integer> numbers = new ArrayList<>();
        int amount = setAmount();
        for (int i = 0; i < amount; i++) {
            numbers.add((int) (-20 + Math.random() * 40));
        }
        printList(Collections.singletonList(numbers));
        System.out.println("\nAverage: " + numbers.stream().mapToInt(i -> i).average().getAsDouble() + "\n");
    }

    public void getUpperCase() {
        List<String> strings = new ArrayList<>();
        String temp;
        int amount = setAmount();
        scanner.nextLine();
        for (int i = 0; i < amount; i++) {
            System.out.print("The " + (i + 1) + " element: ");
            temp = scanner.nextLine();
            strings.add(temp);
        }
        printList(Collections.singletonList(strings));
        System.out.println("\nList with pairs:");
        List<Pair> pairs = strings.stream()
                .map(i -> new Pair(i, i.toUpperCase()))
                .collect(Collectors.toList());
        System.out.print(pairs + "\n\n");
    }

    public void filterByParameters() {
        List<String> strings = new ArrayList<>();
        String temp;
        int amount = setAmount();
        scanner.nextLine();
        for (int i = 0; i < amount; i++) {
            System.out.print("The " + (i + 1) + " element: ");
            temp = scanner.nextLine();
            strings.add(temp);
        }
        printList(Collections.singletonList(strings));
        System.out.println("\nStrings with length = 4 and written in lowercase:");
        strings.stream()
                .filter(i -> i.length() == 4)
                .filter(i -> i.equals(i.toLowerCase()))
                .forEach(System.out::println);
        System.out.println();
    }

    public int setAmount() {
        int amount;
        System.out.println("How many elements would you like to add to the list?");
        do {
            System.out.print("Input: ");
            amount = scanner.nextInt();
        } while (amount <= 0);
        return amount;
    }

    public void printList(List<Object> list) {
        System.out.println("Your list:");
        for (Object o : list) {
            System.out.print(o + " ");
        }
    }
}
