package ru.itis.inf304.lab34.timer_task;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Setter
@Getter
public class AlarmClock {
    private Date date;
    private File sound;

    public AlarmClock(Date date) {
        this.date = date;
    }

    public AlarmClock(Date date, File sound) {
        this.date = date;
        this.sound = sound;
    }

    public void startAlarmClock() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                PlayWAV.playWavFromFile(new File("src/main/java/ru/itis/inf304/lab34/timer_task/rocket.wav"));
                timer.cancel();
            }
        }, date);
    }
}
