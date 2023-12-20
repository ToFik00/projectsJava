package ru.itis.inf304.lab28c;

public class ElevatorFree implements IElevatorFree {
    private ElevatorLinkedList linkedList = new ElevatorLinkedList();
    @Override
    public Elevator free() throws OccupiedElevatorsException {
        Elevator elevator = null;
        for (int i = 0; i < linkedList.getSize(); i++) {
            ElevatorStatus status = linkedList.getCurrent().getValue().getStatus();
            if (status == ElevatorStatus.FREE) {
                elevator = linkedList.getCurrent().getValue();
                break;
            }
            else if (status == ElevatorStatus.BUSY) {
                linkedList.next();
            }
        }
        if (elevator == null) throw new OccupiedElevatorsException();
        return elevator;
    }

    public void add(Elevator elevator) {
        linkedList.add(elevator);
    }

    public ElevatorLinkedList getLinkedList() {
        return linkedList;
    }

    public void setLinkedList(ElevatorLinkedList linkedList) {
        this.linkedList = linkedList;
    }
}
