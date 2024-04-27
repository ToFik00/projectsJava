package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class RoofConstruction implements Runnable {
    Thread[] dependencies;
    private final int days = 3;

    RoofConstruction(Thread... threads) {
        dependencies = threads;
    }

    @Override
    public void run() { // Возведение крыши
        System.out.println("Start [Возведение крыши]");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End [Возведение крыши]");
    }
}
