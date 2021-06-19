package homework5_oop;

public class Lion extends WildAnimal {

    public Lion(int id, int age, double weight, String color) {
        super(id, age, weight, color, true);
    }

    @Override
    public String toString() {
        return "Lion{" + super.toString() + "}";
    }
}
