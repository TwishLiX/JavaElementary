package homework5_oop;

public class Fish extends Pet {

    public Fish(int id, int age, double weight, String color, String name) {
        super(id, age, weight, color, name, null);
    }

    @Override
    public String makeSound() {
        return "....";
    }

    @Override
    public String toString() {
        return "Fish{" + super.toString() + "}";
    }
}
