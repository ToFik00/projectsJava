package ru.itis.inf304.lab28c;

public class OccupiedElevatorsException extends Exception {
    OccupiedElevatorsException() {
        super("Все лифты заняты.");
    }
}
