package ru.itis.inf304.test2;

import lombok.Getter;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class LoggerService {
    @Getter
    private static final Logger logger = Logger.getLogger("logs");

    public static void create() {
        try {
            FileHandler fh = new FileHandler("src/main/resources/" + Main.getVariantName() + ".log", true);
            logger.addHandler(fh);
            fh.setFormatter(new SimpleFormatter());
        } catch (SecurityException | IOException e) {
            logger.log(Level.SEVERE, "Произошла ошибка при работе с FileHandler.", e);
        }
    }

}