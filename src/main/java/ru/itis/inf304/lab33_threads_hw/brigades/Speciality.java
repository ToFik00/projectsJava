package ru.itis.inf304.lab33_threads_hw.brigades;

import lombok.Getter;
import lombok.Setter;
import ru.itis.inf304.lab33_threads_hw.description_work.Work;


@Getter
public class Speciality extends Thread {
    @Setter
    protected String nameBrigade;
    @Setter
    protected long workingDays;
    @Setter
    protected long dominoDays;
    @Setter
    private Work arriveAfterWork;
    private final Work[] works;

    public Speciality(String name, Work arriveAfterWork, Work... works) {
        nameBrigade = name;
        this.arriveAfterWork = arriveAfterWork;
        this.works = works;
    }

    @Override
    public void run() {
        if (arriveAfterWork != null) {
        try {
            arriveAfterWork.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        }
        long startTimeOfWorkingDay = System.currentTimeMillis();
        //while (Arrays.stream(works).noneMatch(Thread::isAlive)) System.out.println("i am waiting");
        try {
            for (Work work : works) {
                work.join(); // для того, чтобы бригада ушла домой, после окончания всех их работ
                workingDays += work.getDays();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getClass().getSimpleName() + " " + workingDays);
        dominoDays = ((System.currentTimeMillis() - startTimeOfWorkingDay) / 1000) - workingDays;
    }

}
