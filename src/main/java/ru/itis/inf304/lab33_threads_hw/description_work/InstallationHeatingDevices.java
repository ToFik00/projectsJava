package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class InstallationHeatingDevices implements Runnable {
    Thread[] dependencies;
    private final int days = 3;

    InstallationHeatingDevices(Thread... threads) {
        dependencies = threads;
    }

    @Override
    public void run() { // Установка отопительных приборов
        System.out.println("Start [Установка отопительных приборов]");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End [Установка отопительных приборов]");
    }
}
