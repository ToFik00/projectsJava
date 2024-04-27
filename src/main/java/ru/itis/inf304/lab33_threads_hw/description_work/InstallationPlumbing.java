package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class InstallationPlumbing implements Runnable {
    Thread[] dependencies;
    private final int days = 2;

    InstallationPlumbing(Thread... threads) {
        dependencies = threads;
    }

    @Override
    public void run() { // Установка сантехники
        System.out.println("Start [Установка сантехники]");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End [Установка сантехники]");
    }
}
