package homework6_interfaces;

public interface TakeHome {
    default void takeHome() {
        System.out.println("OK, we're going home now.");
    }
}
