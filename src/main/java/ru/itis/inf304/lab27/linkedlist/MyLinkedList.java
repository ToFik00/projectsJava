package ru.itis.inf304.lab27.linkedlist;

public class MyLinkedList<T> implements MyList<T> {

    private Node<T> current;
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void add(T value) {
        Node<T> node = new Node(value);
        node.next = head; //+
        if (head == null) {
            head = node;
            tail = head;
            current = head;
        }
        else {
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }

    @Override
    public Node<T> next() {
        if (hasNext()) {
            current = current.next;
            return current;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return current.next != null;
    }

    public Node<T> getCurrent() {
        return current;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    @Override
    public int getSize() {
        return size;
    }
}