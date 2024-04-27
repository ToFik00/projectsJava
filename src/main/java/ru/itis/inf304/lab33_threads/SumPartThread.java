package ru.itis.inf304.lab33_threads;

public class SumPartThread extends Thread {
    private final double start;
    private final int amount;
    private final double stage;
    private int currentStage;

    public SumPartThread(double start, int amount, double stage) {
        this.start = start;
        this.amount = amount;
        this.stage = stage;
    }

    public void run() {
        while (currentStage <= amount) {
            currentStage++;
            Integration.sum = start + stage * currentStage;
        }
    }
}
