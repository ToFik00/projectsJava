package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class ElectricalWiring implements Runnable {
    Thread[] dependencies;
    private final int days = 3;

    ElectricalWiring(Thread... threads) {
        dependencies = threads;
    }

    @Override
    public void run() { // Прокладка электропроводки
        System.out.println("Start [Прокладка электропроводки]");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End [Прокладка электропроводки]");
    }
}
