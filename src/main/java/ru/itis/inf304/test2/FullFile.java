package ru.itis.inf304.test2;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FullFile {

    public static void collectFiles(String pathName, PartFile... partFiles) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(pathName))) {
            for (PartFile partFile : partFiles) {
                dos.write(partFile.getS());
                dos.writeChar('\n');
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
