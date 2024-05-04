package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class FloorFinishing extends Work {

    public FloorFinishing(Thread... threads) {
        super("Отделка пола", 7, threads);
    }

}
