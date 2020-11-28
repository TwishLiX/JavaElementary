package homework7_customCollection;

import java.util.Scanner;

public class Main {
    public StringCollection collection = new StringCollection();
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Main main = new Main();
        int action;
        System.out.println("1 - Add elements to collection");
        System.out.println("2 - Edit element by its index.");
        System.out.println("3 - Delete element (by value)");
        System.out.println("4 - Delete element (by index)");
        System.out.println("5 - Print all elements from collection");
        System.out.println("0 - Exit");
        do {
            System.out.print("Choose a task to run: ");
            action = scanner.nextInt();
            switch (action) {
                case 1:
                    main.addElements();
                    break;
                case 2:
                    main.editElements();
                    break;
                case 3:
                    main.deleteElementsByValue();
                    break;
                case 4:
                    main.deleteElementsByIndex();
                    break;
                case 5:
                    main.printElements();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Incorrect!");
                    break;
            }
        } while (true);
    }

    public void addElements() {
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

    public void editElements() {
        String tempString;
        int amount;
        if (collection.size() == 0) {
            System.out.println("Collection is empty.");
        } else {
            System.out.println("How many elements would you like to edit?");
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
                        System.out.print("Input an index of the " + (i + 1) + " element you'd like to edit: ");
                        index = scanner.nextInt();
                        if (index < 0 || index > collection.size() - 1) {
                            System.out.println("Index is out of range.");
                        }
                    } while (index < 0 || index > collection.size() - 1);
                    scanner.nextLine();
                    System.out.print("Input a new string: ");
                    tempString = scanner.nextLine();
                    collection.add(index, tempString);
                }
            }
        }
    }

    public void deleteElementsByValue() {
        String tempString;
        if (collection.size() == 0) {
            System.out.println("Collection is empty.");
        } else {
            scanner.nextLine();
            System.out.print("Input a string value you'd like to delete from the collection: ");
            tempString = scanner.nextLine();
            collection.delete(tempString);
        }
    }

    public void deleteElementsByIndex() {
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
                System.out.println("Amount of elements is bigger than collection size.");
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
                    collection.delete(index);
                }
            }
        }
    }

    public void printElements() {
        if (collection.size() == 0) {
            System.out.println("Collection is empty.");
        } else {
            for (int i = 0; i < collection.size(); i++) {
                System.out.println(collection.get(i));
            }
        }
    }
}