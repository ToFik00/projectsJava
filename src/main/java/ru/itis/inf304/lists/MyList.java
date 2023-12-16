package ru.itis.inf304.lists;

public interface MyList {
    void add(int e); //+
    int getSize(); //+
    Node next(); //+
    boolean hasNext(); //+
    int max(); //+
    int min(); //+
    int compare(int e1, int e2); //+
}
