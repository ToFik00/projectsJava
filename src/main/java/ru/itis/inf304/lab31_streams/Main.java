package ru.itis.inf304.lab31_streams;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        File file1 = new File(args[0]);
        File file2 = new File(args[1]);
        File fileResult = new File(args[2]);
        File fileResult2 = new File("fileBinary1");

        addInfo(file1, file2, fileResult);
        System.out.println(secondTask(fileResult));
        thirdTask(fileResult, fileResult2);
        fourthTask(fileResult2);
    }

    public static void addInfo(File file1, File file2, File fileResult) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileResult);
             FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {
                fos.write(fis1.readAllBytes());
                fos.write(System.lineSeparator().getBytes());
                fos.write(fis2.readAllBytes());
        }
    }

    public static HashMap<Character, Integer> secondTask(File fileInput) throws IOException {
        HashMap<Character, Integer> map;
        try (FileInputStream fis = new FileInputStream(fileInput)) {
            map = new HashMap<>();
            int b;
            while ((b = fis.read()) != -1) {
                char bch = (char) b;
                if (!map.containsKey(bch) ) map.put(bch, 1);
                else map.put(bch, map.get(bch) + 1);
            }
        }
        return map;
    }

    public static void thirdTask(File inputFile, File fileResult) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputFile)) {
            byte[] bytes = fis.readAllBytes();
            int size = bytes.length;
            try (DataOutputStream dot = new DataOutputStream(new FileOutputStream(fileResult))) {
                dot.writeInt(size);
                dot.write(bytes);
            }
        }
    }

    public static void fourthTask(File inputFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputFile)) {
            StringBuilder stringBuilder = new StringBuilder();
            int count = 0;
            int b;
            while ((b = fis.read()) != -1 && count != 4) {
                count++;
                stringBuilder.append(b);
            }
            int size = Integer.parseInt(stringBuilder.toString());
            System.out.println("size: " + size);

            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }
        }
    }
}
