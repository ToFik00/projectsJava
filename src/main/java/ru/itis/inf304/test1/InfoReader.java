package ru.itis.inf304.test1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class InfoReader {
    public static List<String> read(String pathSchedule) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(pathSchedule)); // 1.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}
