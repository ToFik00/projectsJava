package ru.itis.inf304.lab27;

import ru.itis.inf304.lab27.linkedlist.MyLinkedList;

import java.util.LinkedList;

public class Queue implements ITicketIssuance {
    private final MyLinkedList<Integer> linkedList = new MyLinkedList<>();

    Queue() {
        for (int i = 1; i <= 10; i++) {
            linkedList.add(i);
        }
    }
    @Override
    public int next() {
        int result = linkedList.getCurrent().getValue();
        linkedList.next();
        return result;
    }
}
