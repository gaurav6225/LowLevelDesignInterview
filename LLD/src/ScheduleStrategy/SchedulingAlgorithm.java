package ScheduleStrategy;


import Controller.ElevatorController;

public interface SchedulingAlgorithm {
    public void startSchedulingAlgo(ElevatorController controller);
    public void schedule();
}
