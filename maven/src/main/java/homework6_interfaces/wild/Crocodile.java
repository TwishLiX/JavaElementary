package homework6_interfaces.wild;

import homework6_interfaces.Swimmable;
import homework6_interfaces.Voiceable;

public class Crocodile extends WildAnimal implements Voiceable, Swimmable {

    public Crocodile(int id, int age, double weight, String color) {
        super(id, age, weight, color, true);
    }

    @Override
    public String makeSound() {
        return ("Hello, I'm a wild animal and I'm angry. ");
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
