package ru.itis.inf304.lab28c;

public class ElevatorEven extends Elevator {
    ElevatorEven(int maximumStage, int index) {
        super(maximumStage, index);
    }

    @Override
    public String toString() {
        return "ElevatorEven {" +
                "index=" + super.getIndex() +
                ", status=" + super.getStatus() +
                '}';
    }
    //чётные
}
