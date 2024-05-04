package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public class LayingCommunications extends Work {

    public LayingCommunications(Thread... threads) {
        super("Прокладка коммуникаций", 4, threads);
    }

}
