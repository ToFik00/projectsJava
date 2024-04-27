package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class InstallationWindows implements Runnable {
    Thread[] dependencies;
    private final int days = 1;

    InstallationWindows(Thread... threads) {
        dependencies = threads;
    }

    @Override
    public void run() { // Установка окон
        System.out.println("Start [Установка окон]");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End [Установка окон]");
    }
}
