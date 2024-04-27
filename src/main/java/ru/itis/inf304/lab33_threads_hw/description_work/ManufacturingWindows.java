package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class ManufacturingWindows implements Runnable {
    Thread[] dependencies;
    private final int days = 7;

    ManufacturingWindows(Thread... threads) {
        dependencies = threads;
    }

    @Override
    public void run() { // Изготовление окон
        System.out.println("Start [Изготовление окон]");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End [Изготовление окон]");
    }
}
