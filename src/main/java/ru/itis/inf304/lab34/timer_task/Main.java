package ru.itis.inf304.lab34.timer_task;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date;
        if (args.length > 0) {
            date = parseDate(args[0] + " " + args[1]);
        }
        else {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
                date = parseDate(bufferedReader.readLine());
                } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (date != null) {
            AlarmClock alarmClock = new AlarmClock(date, new File("rocket.wav"));
            alarmClock.startAlarmClock();
        }

    }

    public static Date parseDate(String string) {
        Date date;
        try {
            date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(string);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }


}
