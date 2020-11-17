package homework4_classes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = null;
        double wholeDistance = 478.8;
        double pricePerLitre;
        double tempTankVolume;
        double tempTankResidue;
        double tempFuelPer100;
        do {
            System.out.print("Input a tank volume: ");
            tempTankVolume = scanner.nextDouble();
            System.out.print("Input a tank residue: ");
            tempTankResidue = scanner.nextDouble();
            System.out.print("Input a fuel consumption per 100km: ");
            tempFuelPer100 = scanner.nextDouble();
            System.out.print("Input a price per litre (in UAH): ");
            pricePerLitre = scanner.nextDouble();
            if (tempTankVolume <= 0 || tempTankResidue <= 0 || tempFuelPer100 <= 0 || pricePerLitre <= 0) {
                System.out.println("Incorrect value.");
            } else {
                car = new Car(tempTankVolume, tempTankResidue, tempFuelPer100);
            }
        } while (tempTankVolume <= 0 || tempTankResidue <= 0 || tempFuelPer100 <= 0 || pricePerLitre <= 0);
        System.out.println(car);
        System.out.println("The full price for the trip: " + car.roundToHundredths((car.getFuelPer100() / 100 * wholeDistance) * pricePerLitre) + "UAH");
        System.out.println("Odessa - Kryve Ozero:");
        car.determineRefuelingVolume(152.8);
        car.setFullTank();
        System.out.println("Kryve Ozero - Zhashkiv:");
        car.determineRefuelingVolume(177.8);
        car.setFullTank();
        System.out.println("Zhashkiv - Kyiv:");
        car.determineRefuelingVolume(148.2);
        System.out.println("Residue in the end of the trip: " + car.getTankResidue() + " litre(s)");
    }
}
