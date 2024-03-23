package ru.itis.inf304.test1;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> lines = InfoReader.read("schedule.txt");
        Map<String, List<Program>> channelsWithPrograms = InfoParser.parse(lines);

        BroadcastService broadcastService = new BroadcastService(channelsWithPrograms);
    }
}
