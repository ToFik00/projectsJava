package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class InstallationHeatingDevices extends Work {

    public InstallationHeatingDevices(Thread... threads) {
        super("Установка отопительных приборов", 3, threads);
    }

}
