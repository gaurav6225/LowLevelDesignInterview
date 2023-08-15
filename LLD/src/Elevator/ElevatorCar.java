package Elevator;


import Enums.ElevatorMovingDirection;
import Panel.ElevatorPanel;

public class ElevatorCar {
    private int id;
    private int currentFloor;
    private ElevatorMovingDirection direction;
    private int maxCapacity;
    private Door door;
    private ElevatorPanel elevatorPanel;

    public ElevatorCar(int id) {
        this.id = id;
        this.door = new Door(id);
        this.maxCapacity = 10;
        this.currentFloor = 1;
        this.direction = ElevatorMovingDirection.IDLE;
        this.elevatorPanel = new ElevatorPanel();
    }

    public void pressButton(int floor) {
        this.elevatorPanel.pressButton(floor);
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }
    public ElevatorMovingDirection getDirection() {
        return this.direction;
    }

    public void setCurrentFloor(int floor) {
        System.out.println("Elevator " + this.id + " has been arrived at floor " + floor);
        this.door.doorOpen();
        this.currentFloor = floor;
        this.door.closeDoor();
    }
    public void setDirection(ElevatorMovingDirection direction) {
        System.out.println("Elevator " + this.id + " changing the direction to " + direction);
        this.direction = direction;
    }


}
