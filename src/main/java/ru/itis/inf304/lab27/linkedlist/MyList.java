package ru.itis.inf304.lab27.linkedlist;

public interface MyList<T> {
    void add(T e); //+
    int getSize(); //+
    Node next(); //+
    boolean hasNext(); //+
}
