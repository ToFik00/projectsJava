package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class CompletionConstruction implements Runnable {
    Thread[] dependencies;
    private final int days = 0;

    CompletionConstruction(Thread... threads) {
        dependencies = threads;
    }

    @Override
    public void run() {
        System.out.println("Start [Завершение строительства]");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End [Завершение строительства]");
    }

}
