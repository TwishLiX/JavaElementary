package homework5_oop;

public class Cat extends Pet {

    public Cat(int id, int age, double weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated);
    }

    @Override
    public String makeSound() {
        return super.makeSound() + "Meow.";
    }

    @Override
    public String toString() {
        return "Cat{" + super.toString() + "}";
    }
}
