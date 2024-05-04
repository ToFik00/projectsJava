package ru.itis.inf304.lab33_threads.SingletonTesting;

import java.io.*;

public class Singletone {

    private static volatile Singletone instance;

    private Singletone() {}

    public static Singletone getInstance() {
        if (instance == null) {
            synchronized (Singletone.class) {
                if (instance == null) {
                    instance = new Singletone();
                }
            }
        }
        return instance;
    }

    public String read(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)))) {
            String current;
            while ((current = bufferedReader.readLine()) != null) {
                stringBuilder.append(current).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    public void write(String text, String path) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(text);
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

}