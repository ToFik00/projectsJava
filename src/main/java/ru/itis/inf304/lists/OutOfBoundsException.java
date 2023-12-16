package ru.itis.inf304.lists;

public class OutOfBoundsException extends Exception {
    OutOfBoundsException(int index, int size) {
        super(String.format("Индекс <%d> выходит за пределы списка с размером <%d>.", index, size));
    }
}
