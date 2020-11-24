package homework6_interfaces;

public class Giraffe extends WildAnimal {

    public Giraffe(int id, int age, double weight, String color) {
        super(id, age, weight, color, false);
    }

    @Override
    public String toString() {
        return "Giraffe{" + super.toString() + "}";
    }
}
