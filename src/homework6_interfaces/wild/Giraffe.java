package homework6_interfaces.wild;

import homework6_interfaces.Voiceable;

public class Giraffe extends WildAnimal implements Voiceable {

    public Giraffe(int id, int age, double weight, String color) {
        super(id, age, weight, color, false);
    }

    @Override
    public String makeSound() {
        return ("Hello, I'm a wild animal.");
    }

    @Override
    public String toString() {
        return "Giraffe{" + super.toString() + "}";
    }
}
