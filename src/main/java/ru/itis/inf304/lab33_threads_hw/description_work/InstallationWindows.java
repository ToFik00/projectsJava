package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class InstallationWindows extends Work {

    public InstallationWindows(Thread... threads) {
        super("Установка окон", 1, threads);
    }

}
