package homework6_interfaces;

public class Lion extends WildAnimal implements Swim {

    public Lion(int id, int age, double weight, String color) {
        super(id, age, weight, color, true);
    }

    @Override
    public void swim() {
        System.out.println("I can do that, but what for?");
    }

    @Override
    public String toString() {
        return "Lion{" + super.toString() + "}";
    }
}
