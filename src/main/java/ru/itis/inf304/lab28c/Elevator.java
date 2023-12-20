package ru.itis.inf304.lab28c;

public abstract class Elevator {

    private int index;

    private ElevatorStatus status;

    private int maximumStage;

    Elevator(int maximumStage, int index) {
        this.maximumStage = maximumStage;
        this.index = index;
        status = ElevatorStatus.FREE;
    }

    @Override
    public String toString() {
        return "Elevator {" +
                "index=" + index +
                ", status=" + status +
                '}';
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ElevatorStatus getStatus() {
        return status;
    }

    public void setStatus(ElevatorStatus status) {
        this.status = status;
    }

    public int getMaximumStage() {
        return maximumStage;
    }

    public void setMaximumStage(int maximumStage) {
        this.maximumStage = maximumStage;
    }
}
