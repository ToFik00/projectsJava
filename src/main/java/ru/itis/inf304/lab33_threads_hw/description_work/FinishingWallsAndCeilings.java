package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class FinishingWallsAndCeilings implements Runnable {
    Thread[] dependencies;
    private final int days = 7;

    FinishingWallsAndCeilings(Thread... threads) {
        dependencies = threads;
    }

    @Override
    public void run() { // Отделка стен и потолка
        System.out.println("Start [Отделка стен и потолка]");
        System.out.println("End [Отделка стен и потолка]");
    }
}
