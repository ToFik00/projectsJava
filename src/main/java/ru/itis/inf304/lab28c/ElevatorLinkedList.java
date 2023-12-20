package ru.itis.inf304.lab28c;
public class ElevatorLinkedList {

    private Node current;
    private Node head;
    private Node tail;
    private int size;

    public void add(Elevator value) {
        Node node = new Node(value);
        node.setNext(head); //+
        if (head == null) {
            head = node;
            tail = head;
            current = head;
        }
        else {
            tail.setNext(node);
            tail = tail.getNext();
        }
        size++;
    }

    public Node next() {
        current = current.getNext();
        return current;
    }

    public Node getCurrent() {
        return current;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }
}