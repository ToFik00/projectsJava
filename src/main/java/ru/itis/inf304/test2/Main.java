package ru.itis.inf304.test2;

import lombok.Getter;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    @Getter
    private static final String variantName = "v8";
    public static void main(String[] args) {
        LoggerService.create();
        PartFile[] parts = new PartFile[0];
        File fileDirectory = new File("for_test2");

        try (ExecutorService executorService = Executors.newFixedThreadPool(21)) {
            File[] files;
            if ((files = fileDirectory.listFiles()) != null) {
                parts = new PartFile[files.length];
                for (int i = 0; i < files.length; i++) {
                    PartFile partFile = new PartFile(files[i].getPath());
                    parts[i] = partFile;
                    executorService.execute(partFile);
                }
            }
        }

        Arrays.sort(parts, Comparator.comparingInt(PartFile::getP));
        FullFile.collectFiles(variantName + ".txt", parts);
    }

}
