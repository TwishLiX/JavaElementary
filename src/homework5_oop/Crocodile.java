package homework5_oop;

public class Crocodile extends WildAnimal {

    public Crocodile(int id, int age, double weight, String color) {
        super(id, age, weight, color, true);
    }

    @Override
    public String toString() {
        return "Crocodile{" + super.toString() + "}";
    }
}
