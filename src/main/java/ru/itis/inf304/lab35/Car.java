package ru.itis.inf304.lab35;


import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;

@Getter
public class Car extends Thread {

    private static final DecimalFormat decimalFormat = new DecimalFormat( "#.#" );

    @Setter
    private Car[] cars;

    private final int maxSpeed = 70;
    private final int length = 5;
    private final int minDistanceBetweenCars = 5;
    private final double accelerationBreaking = ((100 / 3.6) * (100 / 3.6)) / (2 * 50);
    private final double acceleration = 100_000d / 3600d;

    private long timeMilli;
    private double currentSpeed = 0;
    @Setter
    private double currentDistance;
    @Setter
    private int endDistance;
    @Setter
    private String nameCar;

    public Car(String name, int startDistance, int endDistance, Car... cars) {
        this.nameCar = name;
        this.currentDistance = startDistance;
        this.endDistance = endDistance;
        this.cars = cars;
    }

    @Override
    public void run() {
        try {
            while (currentDistance < endDistance) {
                boolean flag = true; // Разгоняться ли?

                for (Car car : cars) {
                    if ((currentDistance < car.getCurrentDistance())
                            && (car.getCurrentDistance() - car.getLength() - currentDistance < 5)) {
                        System.out.println(car.getCurrentDistance() + " " + currentDistance);
                        flag = false;
                        break;
                    }
                }

                if (flag && (currentSpeed < maxSpeed)) {
                    currentSpeed = Math.min(70, currentSpeed + acceleration);
                    System.out.println(nameCar + " Разгоняется с " + decimalFormat.format(currentSpeed - acceleration)
                            + " км/ч до " + decimalFormat.format(currentSpeed) + " км/ч");
                }
                else if (!flag && currentSpeed > 0) {
                    currentSpeed = Math.max(0, currentSpeed - accelerationBreaking);
                    System.out.println(nameCar + " Тормозит с " + decimalFormat.format(currentSpeed + accelerationBreaking)
                            + " км/ч до " + decimalFormat.format(currentSpeed) + " км/ч");
                }
                currentDistance += currentSpeed / 3.6;
                System.out.println(nameCar + " Едет " + decimalFormat.format(currentSpeed) + " км/ч " + decimalFormat.format(currentDistance) + " м");
                Thread.sleep((long) (1000 * Main.getK()));
                timeMilli += (long) (1000 * Main.getK());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
