package ExternalDispatcherStrategy;

import Controller.ElevatorController;
import Enums.ExternalButtonDirection;

import java.util.ArrayList;
import java.util.List;

public abstract class ExternalButtonDispatcher {
    public List<ElevatorController> controllersList = new ArrayList<>();

    public abstract ElevatorController getElevatorController(int floor, ExternalButtonDirection direction);
}
