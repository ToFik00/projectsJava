package ru.itis.inf304.lab33_threads_hw;

import lombok.Getter;
import lombok.Setter;
import ru.itis.inf304.lab33_threads_hw.brigades.*;
import ru.itis.inf304.lab33_threads_hw.description_work.*;

import java.util.*;

@Getter
@Setter
public class Construction extends Thread {
    private final Work[] workThreads;
    private final Map<String, Speciality> brigades;
    private long timeConstruction;

    public Construction(Map<String, Speciality> brigades, Work... workThreads) {
        this.brigades = brigades;
        this.workThreads = workThreads;
    }

    @Override
    public void run() {
        startConstruct();
    }

    public void startConstruct() {
        long startTimeConstruction = System.currentTimeMillis();
        workThreads[0].start();
        workThreads[1].start(); // TODO: Заметил ошибку, из-за которой бригады не работают и выдают < 0;
        //                          пока не совсем ясно почему, нужно попробовать добавить к "проекту" метод,
        //                          который запускает бригады (достаточно было переставить старт бригад
        //                          после старта работ-потоков).
        //                          Ошибка пропала, после добавления ожидания "1" в Speciality.java

        //Бригада: Carpenters Дни в игре домино: 20
        //Бригада: Bricklayers Дни в игре домино: 7
        //Бригада: Plasterers Дни в игре домино: 41
        //Бригада: Plumbers Дни в игре домино: 41
        //Бригада: Electricians Дни в игре домино: 45
        brigades.forEach((k, v) -> v.start()); // + Speciality: while (Arrays.stream(works).noneMatch(Thread::isAlive)) System.out.println("i am waiting");
        for (int i = 2; i < workThreads.length; i++)
            workThreads[i].start();
        //brigades.forEach((k, v) -> v.start()); // или просто переставить сюда!
        for (Work work : workThreads) {
            try {
                work.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        long endTimeConstruction = System.currentTimeMillis();

        timeConstruction = endTimeConstruction - startTimeConstruction;

    }
}
