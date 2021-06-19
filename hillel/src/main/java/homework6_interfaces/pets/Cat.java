package homework6_interfaces.pets;

import homework6_interfaces.Swimmable;
import homework6_interfaces.Voiceable;

public class Cat extends Pet implements Voiceable, Swimmable {

    public Cat(int id, int age, double weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated);
    }

    @Override
    public void swim() {
        System.out.println("It's my worst nightmare...");
    }

    @Override
    public String makeSound() {
        if (getName() == null || getName().equals("")) {
            return ("Hello. Meow.");
        } else {
            return ("Hello, my name is " + getName() + ". Meow.");
        }
    }

    @Override
    public String toString() {
        return "Cat{" + super.toString() + "}";
    }
}
