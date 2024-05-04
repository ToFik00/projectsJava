package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class FinishingWallsAndCeilings extends Work {

    public FinishingWallsAndCeilings(Thread... threads) {
        super("Отделка стен и потолка", 7, threads);
    }

}
