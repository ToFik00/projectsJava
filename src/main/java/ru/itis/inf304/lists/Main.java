package ru.itis.inf304.lists;

public class Main {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(7);
        linkedList.add(5);
        linkedList.add(1);
        linkedList.add(-12);
        linkedList.add(99999);
        linkedList.add(888);
        linkedList.add(123);

        linkedList.printAll();
    }
}