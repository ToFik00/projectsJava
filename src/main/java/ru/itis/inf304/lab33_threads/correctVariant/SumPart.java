package ru.itis.inf304.lab33_threads.correctVariant;

public class SumPart extends Thread {
    private final double a;
    private final double b;
    private final CommonResource commonResource;
    public static final int N = 100;

    public SumPart(double a, double b, CommonResource commonResource) {
        this.commonResource = commonResource;
        this.a = a;
        this.b = b;
    }


    private Double func(Double x) {
        return Math.sin(x * x);
    }

    @Override
    public void run() {
        double h = (b - a) / N;
        double sum = 0;
        for (int i = 0; i < N; i++)
            sum += h * func(a + i * h + (h / 2));
        synchronized (commonResource) {
            commonResource.result += sum;
        }
    }
}
