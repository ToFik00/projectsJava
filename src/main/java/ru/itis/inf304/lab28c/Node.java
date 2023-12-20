package ru.itis.inf304.lab28c;

public class Node {
    private Elevator value;
    private Node next;

    public Node(Elevator value) {
        this.value = value;
    }

    public Elevator getValue() {
        return value;
    }

    public void setValue(Elevator value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
