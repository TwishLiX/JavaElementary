package homework7_customCollection;

import java.util.Scanner;

public class Main {
    public StringCollection collection = new StringCollection();
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Main main = new Main();
        int action;
        System.out.println("1 - Add elements to the of the collection");
        System.out.println("2 - Add element by index");
        System.out.println("3 - Delete element (by value)");
        System.out.println("4 - Delete element (by index)");
        System.out.println("5 - Print all elements from the collection");
        System.out.println("0 - Exit");
        do {
            System.out.print("Choose a task to run: ");
            action = scanner.nextInt();
            switch (action) {
                case 1:
                    main.addToTheEnd();
                    break;
                case 2:
                    main.addByIndex();
                    break;
                case 3:
                    main.deleteByValue();
                    break;
                case 4:
                    main.deleteByIndex();
                    break;
                case 5:
                    main.print();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Incorrect!");
                    break;
            }
        } while (true);
    }

    public void addToTheEnd() {
        String tempString;
        int amount;
        System.out.println("How many elements would you like to add?");
        do {
            System.out.print("Input: ");
            amount = scanner.nextInt();
        } while (amount < 0);
        scanner.nextLine();
        for (int i = 0; i < amount; i++) {
            System.out.print("The " + (i + 1) + " string: ");
            tempString = scanner.nextLine();
            collection.add(tempString);
        }
    }

    public void addByIndex() {
        String tempString;
        int amount;
        System.out.println("How many elements would you like to add?");
        do {
            System.out.print("Input: ");
            amount = scanner.nextInt();
        } while (amount < 0);
        if (amount > collection.size()) {
            System.out.println("Amount of elements is bigger than the collection size.");
        } else {
            for (int i = 0; i < amount; i++) {
                int index;
                do {
                    System.out.print("Input an index of the " + (i + 1) + " element: ");
                    index = scanner.nextInt();
                    if (index < 0 || index > collection.size()) {
                        System.out.println("Index is out of range.");
                    }
                } while (index < 0 || index > collection.size());
                scanner.nextLine();
                System.out.print("Input a string: ");
                tempString = scanner.nextLine();
                collection.add(index, tempString);
            }
        }
    }

    public void deleteByValue() {
        String tempString;
        if (collection.size() == 0) {
            System.out.println("Collection is empty.");
        } else {
            scanner.nextLine();
            System.out.print("Input a string value you'd like to delete from the collection: ");
            tempString = scanner.nextLine();
            collection.remove(tempString);
        }
    }

    public void deleteByIndex() {
        int amount;
        if (collection.size() == 0) {
            System.out.println("Collection is empty.");
        } else {
            System.out.println("How many elements would you like to delete?");
            do {
                System.out.print("Input: ");
                amount = scanner.nextInt();
            } while (amount < 0);
            if (amount > collection.size()) {
                System.out.println("Amount of elements is bigger than the collection size.");
            } else {
                for (int i = 0; i < amount; i++) {
                    int index;
                    do {
                        System.out.print("Input an index of the " + (i + 1) + " element you'd like to delete: ");
                        index = scanner.nextInt();
                        if (index < 0 || index > collection.size() - 1) {
                            System.out.println("Index is out of range.");
                        }
                    } while (index < 0 || index > collection.size() - 1);
                    collection.remove(index);
                }
            }
        }
    }

    public void print() {
        if (collection.size() == 0) {
            System.out.println("Collection is empty.");
        } else {
            for (int i = 0; i < collection.size(); i++) {
                System.out.println(collection.get(i));
            }
        }
    }
}
