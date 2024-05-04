package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class ManufacturingWindows extends Work {

    public ManufacturingWindows(Thread... threads) {
        super("Изготовление окон", 7, threads);
    }

}
