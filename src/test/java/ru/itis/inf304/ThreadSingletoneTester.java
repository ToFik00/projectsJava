package ru.itis.inf304;

import lombok.Getter;
import ru.itis.inf304.lab33_threads.SingletonTesting.Singletone;

@Getter
public class ThreadSingletoneTester extends Thread {
    private Singletone singletone;

    @Override
    public void run() {
        singletone = Singletone.getInstance();
    }
}
