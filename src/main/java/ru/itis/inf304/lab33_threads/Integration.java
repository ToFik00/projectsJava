package ru.itis.inf304.lab33_threads;

import java.util.LinkedHashMap;
import java.util.Map;

public class Integration {
    public static double sum;
    static Map<Long, Thread> map = new LinkedHashMap<>();

    public static void integral(double a, double b, int parts) {
        int procCount = Main.getProcCount();
        parts += parts % procCount;
        int count = parts / procCount;
        double interval = (b - a) / parts;
        for (int i = 1; i <= procCount; i++) {
            Thread thread = new SumPartThread(count * i * interval, count, interval);
            map.put(thread.threadId(), thread);
            thread.start();
        }
    }

    public static double function(int x) {
        //return Math.sin(x*x);
        return x*x;
    }

}
