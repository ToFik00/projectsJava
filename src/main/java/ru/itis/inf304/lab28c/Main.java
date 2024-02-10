package ru.itis.inf304.lab28c;

public class Main {
    public static void main(String[] args) {
        int maximumStage = 16;
        ElevatorSystem elevatorSystem = new ElevatorSystem(maximumStage);
        ElevatorFree elevatorFreeOdd = elevatorSystem.getElevatorFreeOdd();
        elevatorFreeOdd.add(new ElevatorOdd(maximumStage, 1));
        elevatorFreeOdd.add(new ElevatorOdd(maximumStage, 2));
        elevatorFreeOdd.add(new ElevatorOdd(maximumStage, 3));

        ElevatorFree elevatorFreeEven = elevatorSystem.getElevatorFreeEven();
        elevatorFreeEven.add(new ElevatorEven(maximumStage, 1));
        elevatorFreeEven.add(new ElevatorEven(maximumStage, 2));
        elevatorFreeEven.add(new ElevatorEven(maximumStage, 3));

        ElevatorFree elevatorFreeEmployee = elevatorSystem.getElevatorFreeEmployee();
        elevatorFreeEmployee.add(new ElevatorEmployee(maximumStage, 1));


        // У всех лифтов после вызова будет статус "BUSY"
        System.out.println(elevatorSystem.call(ElevatorType.EMPLOYEE).toString());

        System.out.println(elevatorSystem.call(ElevatorType.ODD).toString());
        System.out.println(elevatorSystem.call(ElevatorType.ODD).toString());
        System.out.println(elevatorSystem.call(ElevatorType.ODD).toString());

        System.out.println(elevatorSystem.call(ElevatorType.EVEN).toString());
        System.out.println(elevatorSystem.call(ElevatorType.EVEN).toString());
        System.out.println(elevatorSystem.call(ElevatorType.EVEN).toString()); // 7 вызовов (дальше нужно освобождать, иначе Exception)

        elevatorSystem.getElevatorFreeEmployee().getLinkedList().getCurrent().getValue().setStatus(ElevatorStatus.FREE);
        //Освобождаю лифты так, потому что в ТЗ не сказано про этажи
        System.out.println(elevatorSystem.call(ElevatorType.EMPLOYEE).toString()); // 8

        elevatorSystem.getElevatorFreeOdd().getLinkedList().next().getValue().setStatus(ElevatorStatus.FREE);
        elevatorSystem.getElevatorFreeOdd().getLinkedList().next().getValue().setStatus(ElevatorStatus.FREE);
        elevatorSystem.getElevatorFreeOdd().getLinkedList().next().getValue().setStatus(ElevatorStatus.FREE);
        System.out.println(elevatorSystem.call(ElevatorType.ODD).toString()); // 9
        System.out.println(elevatorSystem.call(ElevatorType.ODD).toString()); // 10
        System.out.println(elevatorSystem.call(ElevatorType.ODD).toString()); // 11

        elevatorSystem.getElevatorFreeEven().getLinkedList().next().getValue().setStatus(ElevatorStatus.FREE);
        elevatorSystem.getElevatorFreeEven().getLinkedList().next().getValue().setStatus(ElevatorStatus.FREE);
        elevatorSystem.getElevatorFreeEven().getLinkedList().next().getValue().setStatus(ElevatorStatus.FREE);
        System.out.println(elevatorSystem.call(ElevatorType.EVEN).toString()); // 12
        System.out.println(elevatorSystem.call(ElevatorType.EVEN).toString()); // 13
        System.out.println(elevatorSystem.call(ElevatorType.EVEN).toString()); // 14

        elevatorSystem.getElevatorFreeOdd().getLinkedList().next().getValue().setStatus(ElevatorStatus.FREE);
        elevatorSystem.getElevatorFreeOdd().getLinkedList().next().getValue().setStatus(ElevatorStatus.FREE);
        elevatorSystem.getElevatorFreeOdd().getLinkedList().next().getValue().setStatus(ElevatorStatus.FREE);
        System.out.println(elevatorSystem.call(ElevatorType.ODD).toString()); // 15
        System.out.println(elevatorSystem.call(ElevatorType.ODD).toString()); // 16
        System.out.println(elevatorSystem.call(ElevatorType.ODD).toString()); // 17

        elevatorSystem.getElevatorFreeEmployee().getLinkedList().getCurrent().getValue().setStatus(ElevatorStatus.FREE);
        System.out.println(elevatorSystem.call(ElevatorType.EMPLOYEE).toString()); // 18

        elevatorSystem.getElevatorFreeEmployee().getLinkedList().getCurrent().getValue().setStatus(ElevatorStatus.FREE);
        System.out.println(elevatorSystem.call(ElevatorType.EMPLOYEE).toString()); // 19

        elevatorSystem.getElevatorFreeEmployee().getLinkedList().getCurrent().getValue().setStatus(ElevatorStatus.FREE);
        System.out.println(elevatorSystem.call(ElevatorType.EMPLOYEE).toString()); // 20

        //System.out.println(elevatorSystem.call(ElevatorType.EMPLOYEE).toString()); // проверка Exception

    }
}
