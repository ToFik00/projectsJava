package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class InstallationLightingFixtures implements Runnable {
    Thread[] dependencies;
    private final int days = 1;

    InstallationLightingFixtures(Thread... threads) {
        dependencies = threads;
    }

    @Override
    public void run() { // Установка осветительных приборов
        System.out.println("Start [Установка осветительных приборов]");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End [Установка осветительных приборов]");
    }
}
