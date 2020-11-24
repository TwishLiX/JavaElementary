package homework6_interfaces;

public class Crocodile extends WildAnimal implements Swim {

    public Crocodile(int id, int age, double weight, String color) {
        super(id, age, weight, color, true);
    }

    @Override
    public void swim() {
        System.out.println("It's my vocation.");
    }

    @Override
    public String toString() {
        return "Crocodile{" + super.toString() + "}";
    }
}
