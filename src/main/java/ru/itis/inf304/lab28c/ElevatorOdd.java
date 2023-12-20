package ru.itis.inf304.lab28c;

public class ElevatorOdd extends Elevator {
    ElevatorOdd(int maximumStage, int index) {
        super(maximumStage, index);
    }

    @Override
    public String toString() {
        return "ElevatorOdd {" +
                "index=" + super.getIndex() +
                ", status=" + super.getStatus() +
                '}';
    }
    // нечётные
}
