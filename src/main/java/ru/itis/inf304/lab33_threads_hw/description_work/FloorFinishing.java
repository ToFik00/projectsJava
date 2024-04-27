package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class FloorFinishing implements Runnable {
    Thread[] dependencies;
    private final int days = 7;

    FloorFinishing(Thread... threads) {
        dependencies = threads;
    }

    @Override
    public void run() { // Отделка пола
        System.out.println("Start [Отделка пола]");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End [Отделка пола]");
    }
}
