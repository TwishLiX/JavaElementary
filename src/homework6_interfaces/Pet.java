package homework6_interfaces;

public abstract class Pet extends Animal {

    private String name;
    private Boolean isVaccinated;

    public Pet(int id, int age, double weight, String color, String name, Boolean isVaccinated) {
        super(id, age, weight, color);
        this.name = name;
        this.isVaccinated = isVaccinated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public void vaccinate() {
        if (isVaccinated == null) {
            System.out.println("Your pet doesn't need a vaccination.");
        } else if (isVaccinated) {
            System.out.println("Your pet have already been vaccinated.");
        } else {
            isVaccinated = true;
            System.out.println("Your pet is vaccinated now.");
        }
    }

    @Override
    public String makeSound() {
        if (name == null || name.equals("")) {
            return super.makeSound();
        } else {
            return (super.makeSound() + "My name is " + name + ". ");
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "name='" + name + '\'' +
                ", isVaccinated=" + isVaccinated;
    }
}
