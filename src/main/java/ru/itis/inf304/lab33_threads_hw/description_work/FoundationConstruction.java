package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class FoundationConstruction extends Work {

    public FoundationConstruction(Thread... threads) {
        super("Возведение фундамента", 14, threads);
    }

}
