package homework5_oop;

public abstract class WildAnimal extends Animal {

    private boolean isPredator;

    public WildAnimal(int id, int age, double weight, String color, boolean isPredator) {
        super(id, age, weight, color);
        this.isPredator = isPredator;
    }

    public boolean isPredator() {
        return isPredator;
    }

    public void setPredator(boolean predator) {
        isPredator = predator;
    }

    @Override
    public String makeSound() {
        if (!isPredator) {
            return (super.makeSound() + "I'm a wild animal. ");
        } else {
            return (super.makeSound() + "I'm a wild animal and I'm angry. ");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "isPredator=" + isPredator;
    }
}
