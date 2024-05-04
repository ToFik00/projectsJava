package ru.itis.inf304.lab33_threads.correctVariant;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double SP = Math.sqrt(Math.PI);

        int countOfThreads = Runtime.getRuntime().availableProcessors();
        //System.out.println(sum1 + " : " + (endTime1 - startTime1));
        System.out.println("Количество потоков " + countOfThreads);
        double h = SP / countOfThreads;

        List<SumPart> thList = new ArrayList<>();
        CommonResource commonResource = new CommonResource();
        for (int i = 0; i < countOfThreads; i++)
            thList.add(new SumPart(i * h, (i + 1) * h, commonResource));

        long startTime = System.nanoTime();

        thList.forEach(Thread::start);
        thList.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        /*double sum2 = thList.stream()
                .mapToDouble(SummPart::getPartSum)
                .sum();*/

        long endTime = System.nanoTime();
        System.out.println(commonResource.result + " " + (endTime - startTime));
    }
}
