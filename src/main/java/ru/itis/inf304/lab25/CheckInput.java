package ru.itis.inf304.lab25;

public class CheckInput {
//"Введённое значение не является числом."
    public static void checkInput(int value, int[] sortedArray) throws NumberUnderZeroException, NumberFormatException, NumberLessLeastException {
        if (value < 0) throw new NumberUnderZeroException();
        if (sortedArray[0] > value) throw new NumberLessLeastException();
    }
}
