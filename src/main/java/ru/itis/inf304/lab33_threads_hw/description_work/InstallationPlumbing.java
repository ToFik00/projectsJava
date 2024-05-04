package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class InstallationPlumbing extends Work {

    public InstallationPlumbing(Thread... threads) {
        super("Установка сантехники", 2, threads);
    }

}
