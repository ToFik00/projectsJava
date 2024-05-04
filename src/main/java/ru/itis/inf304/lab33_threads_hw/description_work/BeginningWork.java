package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class BeginningWork extends Work {

    public BeginningWork(Thread... threads) {
        super("Начало работ", 0, threads);
    }

}
