package ExternalDispatcherStrategy;

import Controller.ElevatorController;
import Enums.ExternalButtonDirection;
import Utils.Constant;

import java.util.List;

public class FixedFloors extends ExternalButtonDispatcher {

    public FixedFloors(List<ElevatorController> controllersList) {
        this.controllersList = controllersList;
    }

    // Fixed floors are allocated to fixed Elevators based on modulo
    public ElevatorController getElevatorController(int floor, ExternalButtonDirection direction) {
        ElevatorController ec =  controllersList.get((floor % Constant.NO_OF_ELEVATORS));
        ec.handleExternalReq(floor, direction);
        return ec;
    }
}
