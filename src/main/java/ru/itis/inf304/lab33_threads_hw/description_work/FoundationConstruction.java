package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class FoundationConstruction implements Runnable {
    Thread[] dependencies;
    private final int days = 14;

    FoundationConstruction(Thread... threads) {
        dependencies = threads;
    }

    @Override
    public void run() { // Возведение фундамента
        System.out.println("Start [Возведение фундамента]");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End [Возведение фундамента]");
    }
}
