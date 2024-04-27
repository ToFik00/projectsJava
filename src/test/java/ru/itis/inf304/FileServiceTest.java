package ru.itis.inf304;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

import static ru.itis.inf304.lab31_streams.Main.addInfo;

public class FileServiceTest {

    @Test
    public void addInfoTxtTest() throws IOException {
        //text files
        File fileResultActual1 = new File("fileResultActual1.txt");
        File fileResultExpected1 = new File("fileResultExpected1.txt");
        addInfo(new File("file1.txt"), new File("file2.txt"), fileResultActual1);
        try (FileInputStream fis1 = new FileInputStream(fileResultActual1);
             FileInputStream fis2 = new FileInputStream(fileResultExpected1)) {
            fis1.readAllBytes();
            fis2.readAllBytes();
            Assert.assertArrayEquals(fis1.readAllBytes(), fis2.readAllBytes());
        }
    }

    @Test
    public void addInfoBinaryTest() throws IOException {
        //binary files
        File fileResultActual2 = new File("fileResultActual2");
        File fileResultExpected2 = new File("fileResultExpected2");
        addInfo(new File("fileBinary1"), new File("fileBinary2"), fileResultActual2);
        try (FileInputStream fis1 = new FileInputStream(fileResultActual2);
             FileInputStream fis2 = new FileInputStream(fileResultExpected2)) {
            fis1.readAllBytes();
            fis2.readAllBytes();
            Assert.assertArrayEquals(fis1.readAllBytes(), fis2.readAllBytes());
        }
    }
}
