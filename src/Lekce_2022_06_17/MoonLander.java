package Lekce_2022_06_17;

import java.util.Scanner;

public class MoonLander {
    private double height = 200000; // m
    private double speed = 1500; // m/s
    private double time = 0; // s
    private double fuelWeight = 8000; // kg
    private final double ROCKET_WEIGHT = 8000; // kg
    private final double G = 1.6; // m/s^2
    private final double EXHAUST_VELOCITY_OF_COMBUSTION_GASES = 3000; // m/s

    private static Scanner scan = new Scanner(System.in);

    public MoonLander() {
    }

    public static void main(String[] args) {
        MoonLander moonLander = new MoonLander();
        moonLander.play();
    }




    public void play() {
        while (height > 0) {
            currentStatus();
            double enginePower = enterEnginePower();
            updateStatusValues(enginePower);
        }

        System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIII");
        if (height == 0)
            System.out.println("We landed!");
        else
            System.out.println("Opps, somthing went wrong! We crashed!");
    }




    private void currentStatus() {
        System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIII");
        System.out.println("time: " + Math.floor(time) + "s");
        System.out.println("height: " + Math.floor(height) + "m");
        System.out.println("speed: " + Math.floor(speed) + "m/s");
        System.out.println("fuel: " + Math.floor(fuelWeight) + "kg");
    }

    private void updateStatusValues(double enginePower) {
        double timeChange = 10;
        time += timeChange;
        speed = getFallSpeed(time) + getSpeedChange(ROCKET_WEIGHT + fuelWeight, ROCKET_WEIGHT + getFuelWeight(enginePower));
        height -= speed * timeChange;
    }

    private double enterEnginePower() {
        System.out.print("Enter your engine power: ");
        return scan.nextDouble();
    }

    private double getSpeedChange(double currentWeight, double endWeight) {
        return EXHAUST_VELOCITY_OF_COMBUSTION_GASES * Math.log(currentWeight/endWeight);
    }

    private double getFallSpeed(double time) {
        return speed + 0.5*G*Math.pow(time, 2);
    }

    private double getFuelWeight(double enginePower) {
        fuelWeight -= enginePower * 1000 / 100;
        return fuelWeight;
    }
}
