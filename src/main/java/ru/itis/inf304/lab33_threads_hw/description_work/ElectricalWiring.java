package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class ElectricalWiring extends Work {

    public ElectricalWiring(Thread... threads) {
        super("Прокладка электропроводки", 3, threads);
    }

}
