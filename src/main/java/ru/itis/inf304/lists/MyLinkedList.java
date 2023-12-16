package ru.itis.inf304.lists;

public class MyLinkedList implements MyList {

    private Node current;
    private Node head;
    private Node tail;
    private int size;

    @Override
    public void add(int value) {
        Node node = new Node(value);
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
    public Node next() {
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

    public void add(int value, int index) throws OutOfBoundsException {
        if (index < size) {
            Node node = head;
            Node lastNode = null;
            for (int i = 0; i < index; i++) {
                lastNode = node;
                node = node.next;
            }

            Node newNode = new Node(value);
            if (lastNode != null) {
                lastNode.next = newNode;
            }
            newNode.next = node;
            size++;
        }
        else throw new OutOfBoundsException(index, size);
    }

    @Override
    public int compare(int e1, int e2) {
        return e1 - e2;
    }

    @Override
    public int max() {
        int maxValue = head.value;
        while (hasNext()) {
            if (compare(current.value, maxValue) > 0) maxValue = current.value;
            next();
        }
        current = head;
        return maxValue;
    }

    @Override
    public int min() {
        int minValue = head.value;
        while (hasNext()) {
            if (compare(current.value, minValue) < 0) minValue = current.value;
            next();
        }
        current = head;
        return minValue;
    }

    public Node get(int index) throws OutOfBoundsException {
        if (index < size) {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
        else throw new OutOfBoundsException(index, size);
    }

    public void printAll() {
        Node node = head;
        int i = 0;
        while (i < size) {
            System.out.print(node.value + " " );
            node = node.next;
            i++;
        }
        System.out.println();
    }

    public void sort() {
        for (int i = size - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                Node node = head;
                Node lastNode = null;
                for (int k = 0; k < j; k++) {
                    lastNode = node;
                    node = node.next;
                }
                if (compare(node.value, node.next.value) > 0) swapNext(node, lastNode);
            }
        }
    }

    private void swapNext(Node node1, Node prev) {
        if (node1.equals(head)) {
            Node node2 = node1.next;
            node1.next = node2.next;
            node2.next = node1;
            head = node2;
        }
        else if (prev.next.equals(node1)) { // Соседние ли они
            Node node2 = node1.next;
            node1.next = node2.next;
            node2.next = node1;
            prev.next = node2;
        }
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

    @Override
    public int getSize() {
        return size;
    }
}