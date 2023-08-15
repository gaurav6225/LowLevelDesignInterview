package ScheduleStrategy;

import Controller.ElevatorController;
import Elevator.ElevatorCar;
import Enums.ElevatorMovingDirection;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Look implements SchedulingAlgorithm {
    private ElevatorController controller;
    private ScheduledExecutorService exec;
    public Look() {

    }
    // start the elevator's schedule Algorithm
    public void startSchedulingAlgo(ElevatorController controller) {
        this.controller = controller;
        this.exec = Executors.newSingleThreadScheduledExecutor();
        this.exec.scheduleAtFixedRate(this::schedule, 0, 10000, TimeUnit.MILLISECONDS);
    }
    public void schedule() {
        SortedSet<Integer> primaryQueue = controller.getPrimaryQueue();
        SortedSet<Integer> secondaryQueue = controller.getSecondaryQueue();
        ElevatorCar elevatorCar = controller.getElevator();

        if(primaryQueue.isEmpty() && secondaryQueue.isEmpty()) {
            if(elevatorCar.getDirection().equals(ElevatorMovingDirection.IDLE))
                return;
            elevatorCar.setDirection(ElevatorMovingDirection.IDLE);
        } else if(!primaryQueue.isEmpty()) {
            int nxtFloor;
            if(elevatorCar.getDirection().equals(ElevatorMovingDirection.UP)) {
                nxtFloor = primaryQueue.first();
            } else {
                nxtFloor = primaryQueue.last();
            }
            if(elevatorCar.getDirection().equals(ElevatorMovingDirection.IDLE)) {
                if(nxtFloor > elevatorCar.getCurrentFloor()) {
                    elevatorCar.setDirection(ElevatorMovingDirection.UP);
                } else {
                    elevatorCar.setDirection(ElevatorMovingDirection.DOWN);
                }
            }
            elevatorCar.setCurrentFloor(nxtFloor);
            primaryQueue.remove(nxtFloor);
        } else {
            primaryQueue.addAll(secondaryQueue);
            secondaryQueue.clear();
            if(elevatorCar.getDirection().equals(ElevatorMovingDirection.UP)) {
                elevatorCar.setDirection(ElevatorMovingDirection.DOWN);
            } else {
                elevatorCar.setDirection(ElevatorMovingDirection.UP);
            }
        }
        controller.setSecondaryQueue(secondaryQueue);
        controller.setPrimaryQueue(primaryQueue);
    }
}
