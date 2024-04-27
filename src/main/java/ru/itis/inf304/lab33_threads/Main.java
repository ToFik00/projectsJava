package ru.itis.inf304.lab33_threads;

import lombok.Getter;

public class Main {
    @Getter
    private static int procCount = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        //Integration.integral(2, Math.sqrt(Math.PI), 100);
        Integration.integral(0, 1, 100);
        for (Thread thread : Integration.map.values()) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Integration.sum);
    }

}
