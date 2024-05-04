package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class InstallationLightingFixtures extends Work {

    public InstallationLightingFixtures(Thread... threads) {
        super("Установка осветительных приборов", 1, threads);
    }

}
