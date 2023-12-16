package ru.itis.inf304.lab27;

public class Order {
    private Client client;
    private Cook cook;
    private Pizza pizza;
    private final long timeOfOrder;
    private int numberOfOrder;
    private Status status;

    public Order(Client client, Cook cook, Pizza pizza, int numberOfOrder, Status status) {
        this.client = client;
        this.cook = cook;
        this.pizza = pizza;
        this.timeOfOrder = System.currentTimeMillis();
        this.numberOfOrder = numberOfOrder;
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Cook getCook() {
        return cook;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public long getTimeOfOrder() {
        return timeOfOrder;
    }

    public int getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
