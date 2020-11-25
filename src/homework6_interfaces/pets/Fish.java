package homework6_interfaces.pets;

import homework6_interfaces.Swimmable;
import homework6_interfaces.Voiceable;

public class Fish extends Pet implements Voiceable, Swimmable {

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
