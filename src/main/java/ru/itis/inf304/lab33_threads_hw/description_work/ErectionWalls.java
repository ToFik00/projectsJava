package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class ErectionWalls implements Runnable {
    Thread[] dependencies;
    private final int days = 14;

    ErectionWalls(Thread... threads) {
        dependencies = threads;
    }

    @Override
    public void run() { // Возведение стен
        System.out.println("Start [Возведение стен]");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End [Возведение стен]");
    }
}
