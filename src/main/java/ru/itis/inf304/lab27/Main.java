package ru.itis.inf304.lab27;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Client client1 = new Client(Gender.MALE, DiscountCategory.PENSIONER);
        Client client2 = new Client(Gender.FEMALE, DiscountCategory.STANDARD);
        Client client3 = new Client(Gender.MALE, DiscountCategory.STANDARD);

        Cook cook1 = new Cook(Gender.MALE);
        Cook cook2 = new Cook(Gender.MALE);

        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            orders.add(new Order(client1, cook1, Pizza.PEPERONI, queue.next(), Status.COOKED));
        }
        for (int i = 4; i < 9; i++) {
            orders.add(new Order(client2, cook2, Pizza.VEGAN, queue.next(), Status.COOKED));
        }
        for (int i = 9; i < 15; i++) {
            orders.add(new Order(client3, cook1, Pizza.PEPERONI, queue.next(), Status.COOKED));
        }

        orders.get(0).setStatus(Status.COOKING);
        orders.get(2).setStatus(Status.COOKING);
    }
}
