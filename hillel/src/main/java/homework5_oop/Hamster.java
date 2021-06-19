package homework5_oop;

public class Hamster extends Pet{

    public Hamster(int id, int age, double weight, String color, String name) {
        super(id, age, weight, color, name, null);
    }

    @Override
    public String toString() {
        return "Hamster{" + super.toString() + "}";
    }
}
