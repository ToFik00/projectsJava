package ru.itis.inf304.lab29;

public interface List304 {

    void add(Integer element) throws EmptyElementException;
    void delete(int index) throws IndexOutOfBoundsException;;
    Integer get(int index) throws IndexOutOfBoundsException;
    int size();
    Integer pop();

}
