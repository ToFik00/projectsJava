package ru.itis.inf304.lab29;

public class Main { // Коллекции
    public static void main(String[] args) throws EmptyElementException {
        List304ImplAsArray list = new List304ImplAsArray();
        list.add(5);
        list.add(6);
        list.add(2);
        list.add(1);

        List304ImplAsLinked linkedList = new List304ImplAsLinked();
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(2);
        linkedList.add(1);

        System.out.println(list);
        list.delete(1);
        System.out.println("-");
        System.out.println(list);
        list.pop();
        System.out.println("-");
        System.out.println(list);

        System.out.println("//////////////////////////////////");

        System.out.println(linkedList);
        linkedList.delete(1);
        System.out.println("-");
        System.out.println(linkedList);
        linkedList.pop();
        System.out.println("-");
        System.out.println(linkedList);

        List304ImplAsArray listError = new List304ImplAsArray();
        for (long i = 0; i <= (long) Integer.MAX_VALUE + 1; i++) {
            listError.add((int) i);
        }
    }
}
