package homework6_interfaces.wild;

import homework6_interfaces.Swimmable;
import homework6_interfaces.Voiceable;

public class Wolf extends WildAnimal implements Voiceable, Swimmable {

    public Wolf(int id, int age, double weight, String color) {
        super(id, age, weight, color, true);
    }

    @Override
    public String makeSound() {
        return ("Hello, I'm a wild animal and I'm angry. ");
    }

    @Override
    public void swim() {
        System.out.println("I'll swim if only that hare is on the other side of the river");
    }

    @Override
    public String toString() {
        return "Wolf{" + super.toString() + "}";
    }
}
