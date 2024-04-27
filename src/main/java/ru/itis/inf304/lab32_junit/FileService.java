package ru.itis.inf304.lab32_junit;

import java.io.*;

public class FileService {
    public static void addInfo(File file1, File file2, File fileResult) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileResult);
             FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {
            fos.write(fis1.readAllBytes());
            fos.write(System.lineSeparator().getBytes());
            fos.write(fis2.readAllBytes());
        }
    }
}
