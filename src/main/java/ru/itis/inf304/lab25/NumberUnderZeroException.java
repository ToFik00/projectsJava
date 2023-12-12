package ru.itis.inf304.lab25;

public class NumberUnderZeroException extends Exception {
    public NumberUnderZeroException() {
        super("Число меньше нуля.");
    }
}
