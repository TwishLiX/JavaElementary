package homework6_interfaces.wild;

import homework6_interfaces.Swimmable;
import homework6_interfaces.Voiceable;

public class Lion extends WildAnimal implements Voiceable, Swimmable {

    public Lion(int id, int age, double weight, String color) {
        super(id, age, weight, color, true);
    }

    @Override
    public String makeSound() {
        return ("Hello, I'm a wild animal and I'm angry. ");
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
