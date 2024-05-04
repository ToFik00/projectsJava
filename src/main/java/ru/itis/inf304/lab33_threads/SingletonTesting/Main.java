package ru.itis.inf304.lab33_threads.SingletonTesting;

public class Main {
    public static void main(String[] args) {
        Singletone singletone = Singletone.getInstance();
        singletone.write("abrakadabra", "newFileSingletone.txt");
        System.out.print(singletone.read("newFileSingletone.txt"));
    }
}
