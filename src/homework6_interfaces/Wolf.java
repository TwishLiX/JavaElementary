package homework6_interfaces;

public class Wolf extends WildAnimal implements Swim {

    public Wolf(int id, int age, double weight, String color) {
        super(id, age, weight, color, true);
    }

    @Override
    public void swim() {
        System.out.println("I'll swim if only that hare is on the other side of the river");
    }

    @Override
    public String toString() {
        return "Wolf{" + super.toString() + "}";
    }
}
