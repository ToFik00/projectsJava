package ru.itis.inf304.test1;

import java.util.*;

public class BroadcastService {
    Map<String, List<Program>> channelsWithPrograms;

    public BroadcastService(Map<String, List<Program>> channelsWithPrograms) {
        this.channelsWithPrograms = channelsWithPrograms;
    }

    public List<Program> getProgramsInOrder() { // 6.
        List<Program> programs = new ArrayList<>();
        for (String key : channelsWithPrograms.keySet()) {
            programs.addAll(channelsWithPrograms.get(key));
        }
        programs.sort(Comparator.comparing(Program::getTime));
        return programs;
    }

    public List<Program> currentPrograms(BroadcastsTime currentTime) { // 7.
        List<Program> programs = new ArrayList<>();
        for (String key : channelsWithPrograms.keySet()) {
            programs.addAll(currentProgramsInChannel(key, currentTime));
        }
        return programs;
    }

    public List<Program> findProgramsWithName(String name) { // 8.
        List<Program> programs = new ArrayList<>();
        for (String key : channelsWithPrograms.keySet()) {
            for (Program program : channelsWithPrograms.get(key)) {
                if (program.getName().equals(name)) programs.add(program);
            }
        }
        //programs.sort(Comparator.comparing(Program::getTime));
        return programs;
    }

    public List<Program> currentProgramsInChannel(String channel, BroadcastsTime currentTime) {
        List<Program> programsInChannel = channelsWithPrograms.get(channel);
        List<Program> programs = new ArrayList<>();
        for (int i = 0; i < programsInChannel.size() - 1; i++) { // Последнее не узнать, т.к.
            if (currentTime.between(programsInChannel.get(i).getTime(), programsInChannel.get(i+1).getTime())) {
                programs.add(programsInChannel.get(i));
            }
        }
        if (currentTime.between(programs.get(programsInChannel.size() - 1).getTime(), new BroadcastsTime("06:00")))
        //TODO: Программы, которые идут сейчас?
        return null;
    }

    public List<Program> getProgramsInRangeTime(BroadcastsTime t1, BroadcastsTime t2) { // 10.
        List<Program> programs = new ArrayList<>();
        for (String key : channelsWithPrograms.keySet()) {
            for (Program program : channelsWithPrograms.get(key)) {
                if (program.getTime().between(t1, t2)) programs.add(program);
            }
        }
        //programs.sort(Comparator.comparing(Program::getTime));
        return programs;
    }
}
