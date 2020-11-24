package homework6_interfaces;

public class GuideDog extends Dog implements TakeHome {

    public GuideDog(int id, int age, double weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated, true);
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
