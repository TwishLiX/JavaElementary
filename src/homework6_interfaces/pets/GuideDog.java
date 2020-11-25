package homework6_interfaces.pets;

import homework6_interfaces.Swimmable;

public class GuideDog extends Dog implements Swimmable {

    public GuideDog(int id, int age, double weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated, true);
    }

    public void takeHome() {
        System.out.println("Ok, we're going home.");
    }

    @Override
    public String makeSound() {
        return super.makeSound() + "I can take you home.";
    }

    @Override
    public void swim() {
        System.out.println("I don't have time for swimming, I must take my master home.");
    }

    @Override
    public String toString() {
        return super.toString() + " (Guide dog)";
    }
}
