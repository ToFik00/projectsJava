package ru.itis.inf304.lab29;

public class List304ImplAsLinked implements List304 {

    private Node head;
    private Node tail;
    private int size;


    @Override
    public void add(Integer element) throws EmptyElementException {
        if (element == null) throw new EmptyElementException();

        Node node = new Node(element);
        if (head == null) {
            head = node;
        }
        else {
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        if (index > size) throw new IndexOutOfBoundsException();
        if (index != 0) {
            Node current = head;
            Node last = current;
            for (int i = 0; i < index; i++) { // 5 6 2 1
                last = current;
                current = current.getNext();
            }
            last.setNext(current.getNext());

        } else {
            head = head.getNext();
        }
        size--;
    }

    @Override
    public Integer get(int index) throws IndexOutOfBoundsException {
        if (index > size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Integer pop() {
        Node current = head;
        for (int i = 0; i < size - 1; i++) {
            current = current.getNext();
        }

        current.setNext(null);
        size--;
        return tail.getValue();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        for (int i = 0; i < size - 1; i++) {
            result.append(current.getValue()).append("\n");
            current = current.getNext();
        }
        result.append(tail.getValue());
        return result.toString();
    }
}
