package ru.itis.inf304.lab35;

import lombok.Getter;
import lombok.Setter;

public class Main {
    @Getter
    @Setter
    private static double k;

    public static void main(String[] args) throws InterruptedException {
        k = 1;
        int mileage = 1000;
        int amountCars = 5;

        startRace(mileage, amountCars, k);
    }

    public static Car[] getCarsWithoutOne(Car car, Car[] cars) {
        Car[] newCars = new Car[cars.length - 1];
        int count = 0;
        for (Car value : cars) {
            if (value != car) newCars[count++] = value;
        }
        return newCars;
    }

    public static void startRace(int mileage, int amountCars, double k) {
        Car[] cars = new Car[amountCars];
        for (int i = 0; i < cars.length; i++)
            cars[i] = new Car(i+"", 0, mileage);

        for (Car car : cars) {
            try {
                Thread.sleep(5 * (long) (1000 * k));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            car.setCars(getCarsWithoutOne(car, cars));
            car.start();
        }

        long[] time = new long[amountCars];
        for (int i = 0; i < cars.length; i++) {
            try {
                cars[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            time[i] = System.currentTimeMillis();
        }
        for (int i = 0; i < cars.length; i++) System.out.println(cars[i].getNameCar() + " :" + time[i] + " мс");

        long averageTimeIntensity = 0;
        for (int i = 0; i < time.length - 1; i++)
            averageTimeIntensity += time[i+1] - time[i];
        averageTimeIntensity /= time.length - 1;

        System.out.println("Интенсивность: " + averageTimeIntensity + " мс");
    }
}
