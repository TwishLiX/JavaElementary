package homework5_oop;

public class Main {

    public static void main(String[] args) {
        Animal[] animals = new Animal[9];
        animals[0] = new Crocodile(2544, 2, 500.4, "green");
        animals[1] = new Giraffe(3471, 5, 800, "orange");
        animals[2] = new Lion(5501, 6, 150, "yellow");
        animals[3] = new Wolf(5609, 1, 40.65, "gray");
        animals[4] = new Fish(2231, 1, 3.5, "blue", "Dory");
        animals[5] = new Hamster(9854, 4, 0.03, "brown", "");
        animals[6] = new Cat(1000, 2, 4, "black", "Zoe", true);
        animals[7] = new Dog(1001, 7, 6, "white", "Spike", true, false);
        animals[8] = new GuideDog(8008, 2, 5, "black and white", "Cliff", true);

        for (Animal animal : animals) {
            System.out.println(animal);
            System.out.println(animal.makeSound());
        }
    }
}
