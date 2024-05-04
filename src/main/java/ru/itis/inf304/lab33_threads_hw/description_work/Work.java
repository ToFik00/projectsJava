package ru.itis.inf304.lab33_threads_hw.description_work;

import lombok.Getter;

@Getter
public abstract class Work extends Thread {
    protected Thread[] dependencies;
    protected final int days;
    protected final String nameWork;

    public Work(String name, int days, Thread... threads) {
        this.nameWork = name;
        this.days = days;
        dependencies = threads;
    }

    protected void waitDependencies() throws InterruptedException {
        for (Thread dependency : dependencies)
            dependency.join();
    }

    @Override
    public void run() {
        try {
            waitDependencies();
            System.out.println("Start [" + nameWork + "]");
            Thread.sleep(1000L * days);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End [" + nameWork + "]");
    }

    public void setDependencies(Thread... dependencies) {
        this.dependencies = dependencies;
    }
}
