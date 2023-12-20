package ru.itis.inf304.lab28c;

public class ElevatorSystem implements ICalling {
    private int maximumStage;
    private ElevatorFree elevatorFreeOdd = new ElevatorFree();
    private ElevatorFree elevatorFreeEven = new ElevatorFree();
    private ElevatorFree elevatorFreeEmployee = new ElevatorFree();

    public ElevatorSystem(int maximumStage) {
        this.maximumStage = maximumStage;
    }

    @Override
    public Elevator call(ElevatorType elevatorType) {
        try {
            switch (elevatorType) {
                case EVEN -> {
                    Elevator elevator = elevatorFreeEven.free();
                    elevator.setStatus(ElevatorStatus.BUSY);
                    return elevator;
                }
                case ODD -> {
                    Elevator elevator = elevatorFreeOdd.free();
                    elevator.setStatus(ElevatorStatus.BUSY);
                    return elevator;
                }
                case EMPLOYEE -> {
                    Elevator elevator = elevatorFreeEmployee.free();
                    elevator.setStatus(ElevatorStatus.BUSY);
                    return elevator;
                }
            }
        } catch (OccupiedElevatorsException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int getMaximumStage() {
        return maximumStage;
    }

    public void setMaximumStage(int maximumStage) {
        this.maximumStage = maximumStage;
    }

    public ElevatorFree getElevatorFreeOdd() {
        return elevatorFreeOdd;
    }

    public void setElevatorFreeOdd(ElevatorFree elevatorFreeOdd) {
        this.elevatorFreeOdd = elevatorFreeOdd;
    }

    public ElevatorFree getElevatorFreeEven() {
        return elevatorFreeEven;
    }

    public void setElevatorFreeEven(ElevatorFree elevatorFreeEven) {
        this.elevatorFreeEven = elevatorFreeEven;
    }

    public ElevatorFree getElevatorFreeEmployee() {
        return elevatorFreeEmployee;
    }

    public void setElevatorFreeEmployee(ElevatorFree elevatorFreeEmployee) {
        this.elevatorFreeEmployee = elevatorFreeEmployee;
    }
}
