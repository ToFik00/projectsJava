package ru.itis.inf304.lab25;

public class NumberLessLeastException extends Exception {
    public NumberLessLeastException() {
        super("Число меньше наименьшего в массиве.");
    }

}
