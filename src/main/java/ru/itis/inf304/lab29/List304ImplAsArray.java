package ru.itis.inf304.lab29;

import java.util.Arrays;

public class List304ImplAsArray implements List304 {
    private Integer[] elements = new Integer[1];
    private int capacity = 0;
    @Override
    public void add(Integer value) throws EmptyElementException { // throws OverSizeException?
        if (value == null) throw new EmptyElementException();
        if (capacity >= elements.length) {
            Integer[] newElements = new Integer[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            /*for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }*/
            elements = newElements;
        }
        elements[capacity++] = value;
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        if (index > capacity - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (index != capacity - 1) {
            for (int i = index; i < capacity - 1; i++) {
                elements[i] = elements[i + 1];
            }
        }
        else {
            elements[index] = null;
        }
        capacity--;
    }

    @Override
    public Integer get(int index) throws IndexOutOfBoundsException {
        if (index <= capacity - 1) {
            return elements[index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public Integer pop() {
        Integer value = elements[capacity - 1];
        delete(capacity - 1);
        return value;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < capacity - 1; i++) {
            result.append(elements[i]).append("\n");
        }
        result.append(elements[capacity - 1]);
        return result.toString();
    }
}
