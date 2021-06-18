package homework6_interfaces.pets;

import homework6_interfaces.Voiceable;

public class Hamster extends Pet implements Voiceable {

    public Hamster(int id, int age, double weight, String color, String name) {
        super(id, age, weight, color, name, null);
    }

    @Override
    public String makeSound() {
        if (getName() == null || getName().equals("")) {
            return ("Hello. ");
        } else {
            return ("Hello, my name is " + getName() + ".");
        }
    }

    @Override
    public String toString() {
        return "Hamster{" + super.toString() + "}";
    }
}
