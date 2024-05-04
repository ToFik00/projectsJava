package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class CompletionConstruction extends Work {

    public CompletionConstruction(Thread... threads) {
        super("Завершение строительства", 0, threads);
    }

}
