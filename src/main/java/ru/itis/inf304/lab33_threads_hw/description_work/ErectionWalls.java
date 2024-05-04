package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class ErectionWalls extends Work {

    public ErectionWalls(Thread... threads) {
        super("Возведение стен", 14, threads);
    }

}
