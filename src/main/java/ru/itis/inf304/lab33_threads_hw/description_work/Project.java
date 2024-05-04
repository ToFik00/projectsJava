package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class Project extends Work {

    public Project(Thread... threads) {
        super("Проект", 7, threads);
    }

}
