package Elevator;

public class Door {
    private int elevatorIndex;
    public Door(int index) {
        this.elevatorIndex = index;
    }
    public void doorOpen() {
        System.out.println("Elevator " + (this.elevatorIndex) + " Doors are open");
    }
    public void closeDoor() {
        System.out.println("Elevator " + (this.elevatorIndex) + " Doors are closed");
    }
}
