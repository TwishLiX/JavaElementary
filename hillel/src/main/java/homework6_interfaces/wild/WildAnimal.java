package homework6_interfaces.wild;

import homework6_interfaces.Animal;

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
    public String toString() {
        return super.toString() + "isPredator=" + isPredator;
    }
}
