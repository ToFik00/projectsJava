package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class Project implements Runnable {
    Thread[] dependencies;
    private final int days = 7;

    Project(Thread... threads) {
        dependencies = threads;
    }

    @Override
    public void run() { // Проект
        System.out.println("Start [Проект]");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End [Проект]");
    }
}
