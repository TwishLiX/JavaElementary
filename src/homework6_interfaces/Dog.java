package homework6_interfaces;

public class Dog extends Pet implements Swim {

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
    public void swim() {
        System.out.println("Let's go swimming, master.");
    }

    @Override
    public String toString() {
        return "Dog{" + super.toString() + "}";
    }
}
