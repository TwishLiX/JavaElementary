package homework5_oop;

public class Wolf extends WildAnimal {

    public Wolf(int id, int age, double weight, String color) {
        super(id, age, weight, color, true);
    }

    @Override
    public String toString() {
        return "Wolf{" + super.toString() + "}";
    }
}
