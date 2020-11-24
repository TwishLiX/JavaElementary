package homework6_interfaces;

public class Cat extends Pet implements Swim {

    public Cat(int id, int age, double weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated);
    }

    @Override
    public String makeSound() {
        return super.makeSound() + "Meow.";
    }

    @Override
    public void swim() {
        System.out.println("It's my worst nightmare...");
    }

    @Override
    public String toString() {
        return "Cat{" + super.toString() + "}";
    }
}
