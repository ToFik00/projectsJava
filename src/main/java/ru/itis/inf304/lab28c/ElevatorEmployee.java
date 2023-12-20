package ru.itis.inf304.lab28c;

public class ElevatorEmployee extends Elevator {
    ElevatorEmployee(int maximumStage, int index) {
        super(maximumStage, index);
    }

    @Override
    public String toString() {
        return "ElevatorEmployee {" +
                "index=" + super.getIndex() +
                ", status=" + super.getStatus() +
                '}';
    }
    // сотрудники
}
