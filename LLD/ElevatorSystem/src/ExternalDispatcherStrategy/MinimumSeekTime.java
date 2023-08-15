package ExternalDispatcherStrategy;

import Controller.ElevatorController;
import Enums.ExternalButtonDirection;

import java.util.List;

// TODO : Implement the Minimum Seek Algorithm to get the Elevator
public class MinimumSeekTime extends ExternalButtonDispatcher {
    public MinimumSeekTime(List<ElevatorController> controllersList) {
        this.controllersList = controllersList;
    }

    // To be implemented
    public ElevatorController getElevatorController(int floor, ExternalButtonDirection direction) {
        return null;
    }
}
