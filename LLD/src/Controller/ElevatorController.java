package Controller;

import Elevator.ElevatorCar;
import Enums.ElevatorMovingDirection;
import Enums.ExternalButtonDirection;
import ScheduleStrategy.SchedulingAlgorithm;
import ScheduleStrategy.Look;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;


public class ElevatorController {
    private int id;
    private ElevatorCar elevator;
    private SortedSet<Integer> primaryQueue;
    private SortedSet<Integer> secondaryQueue;
    private SchedulingAlgorithm scheduleObj;

    public ElevatorController(int id) {
        this.id = id;
        this.elevator = new ElevatorCar(id);
        this.primaryQueue = new TreeSet<>();
        this.secondaryQueue = new TreeSet<>();
        this.scheduleObj = new Look();
    }

    public void startElevatorController() {
        scheduleObj.startSchedulingAlgo(this);
    }

    // This function handles requests from Hall Panel
    public void handleExternalReq(int fromFloor, ExternalButtonDirection direction) {
        System.out.println("Elevator " + id + " received the request from external panel");
        if(elevator.getDirection() == ElevatorMovingDirection.IDLE) {
            primaryQueue.add(fromFloor);
        } else if(direction == (ExternalButtonDirection.UP)
                && elevator.getDirection() == (ElevatorMovingDirection.UP)
                && elevator.getCurrentFloor() < fromFloor) {
            primaryQueue.add(fromFloor);
        } else if (direction == (ExternalButtonDirection.DOWN)
                && elevator.getDirection() == (ElevatorMovingDirection.DOWN)
                && elevator.getCurrentFloor() > fromFloor) {
            primaryQueue.add(fromFloor);
        } else {
            secondaryQueue.add(fromFloor);
        }
    }

    // This function handles requests from Elevator Panel
    public void handleInternalReq(int reqFloor) {
        System.out.println("Elevator " + id + " received the request from internal pannel");
        elevator.pressButton(reqFloor);
        if(elevator.getDirection() == (ElevatorMovingDirection.IDLE)) {
            primaryQueue.add(reqFloor);
        } else if(elevator.getDirection() == (ElevatorMovingDirection.UP)
                && elevator.getCurrentFloor() < reqFloor) {
            primaryQueue.add(reqFloor);
        } else if (elevator.getDirection() == (ElevatorMovingDirection.DOWN)
                && elevator.getCurrentFloor() > reqFloor) {
            primaryQueue.add(reqFloor);
        } else {
            secondaryQueue.add(reqFloor);
        }
    }

    public SortedSet<Integer> getPrimaryQueue() {
        return this.primaryQueue;
    }
    public SortedSet<Integer> getSecondaryQueue() {
        return this.secondaryQueue;
    }

    public ElevatorCar getElevator() {
        return this.elevator;
    }
    public void setPrimaryQueue(SortedSet<Integer> primaryQueue) {
        this.primaryQueue = primaryQueue;
    }
    public void setSecondaryQueue(SortedSet<Integer> secondaryQueue) {
        this.secondaryQueue = secondaryQueue;
    }
}
