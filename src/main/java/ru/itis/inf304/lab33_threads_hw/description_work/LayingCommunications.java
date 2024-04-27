package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class LayingCommunications implements Runnable {
    Thread[] dependencies;
    private final int days = 4;

    LayingCommunications(Thread... threads) {
        dependencies = threads;
    }

    @Override
    public void run() { // Прокладка коммуникаций
        System.out.println("Start [Прокладка коммуникаций]");
        try {
            Thread.sleep(1000 * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End [Прокладка коммуникаций]");
    }
}
