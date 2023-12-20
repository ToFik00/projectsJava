package ru.itis.inf304.lab28c;

public interface IElevatorFree {
    Elevator free() throws OccupiedElevatorsException;
}
