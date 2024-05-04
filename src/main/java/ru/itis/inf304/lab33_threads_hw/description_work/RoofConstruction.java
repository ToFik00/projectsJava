package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class RoofConstruction extends Work {

    public RoofConstruction(Thread... threads) {
        super("Возведение крыши", 3, threads);
    }

}
