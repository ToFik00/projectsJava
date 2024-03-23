package ru.itis.inf304.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfoParser {

    public static Map<String, List<Program>> parse(List<String> inputValues) {
        Map<String, List<Program>> parsedMap = new HashMap<>();
        String currentChannel = null;
        Program currentProgram = null;
        List<Program> programs = new ArrayList<>();
        for (String line : inputValues) { // 5.
            if (line.startsWith("#")) {
                if (currentChannel != null) {
                    parsedMap.put(currentChannel, programs);
                }
                currentChannel = line;
            } else if (currentChannel != null) {
                if (currentProgram == null) {
                    currentProgram = new Program(currentChannel, new BroadcastsTime(line), null);
                } else {
                    currentProgram.setName(line);
                    programs.add(currentProgram);
                    currentProgram = null;
                }
            } else throw new RuntimeException(); // Для указанной программы нет канала
        }
        return parsedMap;
    }
}
