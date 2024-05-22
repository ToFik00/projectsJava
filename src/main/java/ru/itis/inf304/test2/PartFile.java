package ru.itis.inf304.test2;

import lombok.Getter;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Level;

@Getter
public class PartFile implements Runnable {
    private String fileName;
    private String pathName;
    private int k; // размер в байтах строки с данными в формате UTF-8
    private byte[] s; // строка с данными
    private int d; // контрольное число - количество символов в строке с данными
    private int p; // номер части
    private boolean isMatchD = false;


    public PartFile() {

    }

    public PartFile(String pathName) {
        this.pathName = pathName;
    }

    @Override
    public void run() {
        readFile(pathName);
    }

    public void readFile(String pathName) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(pathName))) {
            fileName = Paths.get(pathName).getFileName().toString();

            k = dis.readInt();
            s = new byte[k];
            for (int i = 0; i < k; i++)
                s[i] = dis.readByte();
            d = dis.readInt();
            p = dis.readInt();

            if (s.length == d) isMatchD = true;
            synchronized (LoggerService.getLogger()) {
                LoggerService.getLogger().log(Level.INFO,
                        "прочитали файл {0}" +
                                " кол-во байт данных: {1}," +
                                " кол-во считанных символов: {2}," +
                                " контрольное число: {3}," +
                                " номер части: {4}", new Object[]{fileName, k, s.length, d, p});
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
