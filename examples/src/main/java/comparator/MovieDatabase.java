package comparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieDatabase {
    static List<Movie> movies = new ArrayList<>();

    public static void main(String[] args) {
        MovieDatabase movieDatabase = new MovieDatabase();
        Scanner switcher = new Scanner(System.in);
        int action;
        System.out.println("What do you like to do?");
        System.out.println("1 - Add elements to the list");
        System.out.println("2 - Remove an element from the list");
        System.out.println("3 - Print all elements from the list");
        System.out.println("4 - Sort elements in the list");
        System.out.println("0 - Exit");
        do {
            System.out.print("Choose an action: ");
            action = switcher.nextInt();
            switch (action) {
                case 1 -> movieDatabase.add();
                case 2 -> movieDatabase.remove();
                case 3 -> movieDatabase.printAll();
                case 4 -> movieDatabase.sort();
                case 0 -> System.exit(0);
                default -> System.out.println("Incorrect!");
            }
        } while (true);
    }

    public void add() {
        Scanner add = new Scanner(System.in);
        int amount = 0, repeatsCounter = 0;
        try {
            do {
                System.out.print("Input an amount of elements you'd like to add and press <Enter>: ");
                amount = Integer.parseInt(add.nextLine());
                if (amount < 1) {
                    System.out.println("Amount of elements must be greater than 0.");
                }
            } while (amount < 1);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect format.");
        }
        for (int i = 0; i < amount; i++) {
            try {
                System.out.print("Input a title of the " + (i + 1) + " movie: ");
                String title = add.nextLine();
                System.out.print("Input a director of the " + (i + 1) + " movie: ");
                String director = add.nextLine();
                System.out.print("Input a year of the " + (i + 1) + " movie: ");
                int year = Integer.parseInt(add.nextLine());
                System.out.print("Input a box office of the " + (i + 1) + " movie: ");
                long box_office = Long.parseLong(add.nextLine());
                System.out.print("Input a mark of the " + (i + 1) + " movie: ");
                short mark = Short.parseShort(add.nextLine());
                if (movies.size() == 0) {
                    movies.add(new Movie(title, director, year, box_office, mark));
                }
                else {
                    boolean isRepeated = false;
                    for (Movie movie : movies) {
                        if (title.equals(movie.getTitle()) && year == movie.getYear()) {
                            repeatsCounter++;
                            isRepeated = true;
                        }
                    }
                    if (!isRepeated) {
                        movies.add(new Movie(title, director, year, box_office, mark));
                    }
                    else {
                        System.out.println("Error. Two elements can't have the same title and year.");
                        if (amount == repeatsCounter) {
                            return;
                        }
                        else {
                            continue;
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect format.");
                i--;
            }
        }
        if (amount - repeatsCounter > 1) {
            System.out.println("Elements were successfully added.");
        }
        else {
            System.out.println("Element was successfully added.");
        }
    }

    public void remove() {
        if (movies.size() == 0) {
            System.out.println("There are no any elements in your database.");
        }
        else {
            Scanner remove = new Scanner(System.in);
            System.out.print("Input an index of element you'd like to remove: ");
            try {
                int index = remove.nextInt();
                if (index >= movies.size() || index < 0) {
                    System.out.println("Selected index is out of range.");
                } else {
                    movies.remove(index);
                    System.out.println("Element was successfully deleted.");
                }
            } catch (Exception e) {
                System.out.println("Incorrect format.");
            }
        }
    }

    public void printAll() {
        if (movies.size() == 0) {
            System.out.println("There are no any elements in your database.");
        }
        else {
            int i = 0;
            for (Movie movie : movies) {
                System.out.println(i + 1 + ". " + movie);
                i++;
            }
        }
    }

    public void sort() {
        if (movies.size() == 0) {
            System.out.println("There are no any elements in your database.");
        }
        else if (movies.size() == 1) {
            System.out.println("There is only one element in your database, we can't sort it.");
        }
        else {
            Scanner switcher = new Scanner(System.in);
            int action;
            do {
                System.out.println("1 - Sort by title");
                System.out.println("2 - Sort by release year");
                System.out.println("3 - Sort by box office");
                System.out.println("4 - Sort by mark");
                System.out.println("5 - Back");
                System.out.print("Choose an action: ");
                action = switcher.nextInt();
                switch (action) {
                    case 1:
                        movies.sort(Movie.compareByTitle);
                        System.out.println("Elements were successfully sorted.");
                        break;
                    case 2:
                        movies.sort(Movie.compareByYear);
                        System.out.println("Elements were successfully sorted.");
                        break;
                    case 3:
                        movies.sort(Movie.compareByBoxOffice);
                        System.out.println("Elements were successfully sorted.");
                        break;
                    case 4:
                        movies.sort(Movie.compareByMark);
                        System.out.println("Elements were successfully sorted.");
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Incorrect!");
                }
            } while (action != 1 && action != 2 && action != 3 && action != 4 && action != 5);
        }
    }

}
