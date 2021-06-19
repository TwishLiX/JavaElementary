package homework5_oop;

public class Dog extends Pet {

    private boolean isTrained;

    public Dog(int id, int age, double weight, String color, String name, boolean isVaccinated, boolean isTrained) {
        super(id, age, weight, color, name, isVaccinated);
        this.isTrained = isTrained;
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void setTrained(boolean trained) {
        isTrained = trained;
    }

    public void bringStick() {
        System.out.println("Take your stick, master.");
    }

    @Override
    public String makeSound() {
        return super.makeSound() + "Woof. ";
    }

    @Override
    public String toString() {
        return "Dog{" + super.toString() + "}";
    }
}
