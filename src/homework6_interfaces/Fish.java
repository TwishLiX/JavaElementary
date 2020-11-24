package homework6_interfaces;

public class Fish extends Pet implements Swim {

    public Fish(int id, int age, double weight, String color, String name) {
        super(id, age, weight, color, name, null);
    }

    @Override
    public String makeSound() {
        return "....";
    }

    @Override
    public void swim() {
        System.out.println("....");
    }

    @Override
    public String toString() {
        return "Fish{" + super.toString() + "}";
    }
}
