package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class MakingDoors extends Work {

    public MakingDoors(Thread... threads) {
        super("Изготовление дверей", 7, threads);
    }

}
