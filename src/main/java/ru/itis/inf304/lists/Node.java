package ru.itis.inf304.lists;

public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public int compareTo(Node node2) {
        return this.value - node2.value;
    }

    public int getValue() {
        return value;
    }
}
