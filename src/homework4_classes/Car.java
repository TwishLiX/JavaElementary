package homework4_classes;

import java.text.DecimalFormat;

public class Car {
    private double tankVolume;
    private double tankResidue;
    private double fuelPer100;

    public Car(double tankVolume, double tankResidue, double fuelPer100) {
        this.tankVolume = tankVolume;
        this.tankResidue = Math.min(tankResidue, tankVolume);
        this.fuelPer100 = fuelPer100;
    }

    public double getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(double tankVolume) {
        this.tankVolume = tankVolume;
    }

    public double getTankResidue() {
        return tankResidue;
    }

    public void setTankResidue(double tankResidue) {
        this.tankResidue = tankResidue;
    }

    public double getFuelPer100() {
        return fuelPer100;
    }

    public void setFuelPer100(double fuelPer100) {
        this.fuelPer100 = fuelPer100;
    }

    public void setFullTank() {
     setTankResidue(getTankResidue() + (getTankVolume() - getTankResidue()));
    }

    public void determineResidue(double km) {
        double consumption = roundToHundredths(getFuelPer100() / 100 * km);
        setTankResidue(roundToHundredths(getTankResidue() - consumption));
        System.out.println("Fuel consumption per " + km + "km: " + consumption + " litre(s)");
        System.out.println("Residue: " + getTankResidue() + " litre(s)");
    }

    public void determineRefuelingVolume(double km) {
        double refuel = roundToHundredths(getTankVolume() - (getTankResidue() - (getFuelPer100() / 100 * km)));
        determineResidue(km);
        System.out.println("To full the tank, the car needs to be refueled by " + refuel + " litre(s)");
    }

    double roundToHundredths(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.parseDouble(decimalFormat.format(value));
    }

    @Override
    public String toString() {
        return "Volume = " + tankVolume +
                ", Residue = " + tankResidue +
                ", Fuel consumption per 100km = " + fuelPer100;
    }
}
