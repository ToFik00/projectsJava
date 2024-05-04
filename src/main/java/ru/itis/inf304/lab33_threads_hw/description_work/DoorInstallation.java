package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class DoorInstallation extends Work {

    public DoorInstallation(Thread... threads) {
        super("Установка дверей", 1, threads);
    }

}
