package ElevatorSystem;

import Building.Building;
import Controller.ElevatorController;
import Enums.ExternalButtonDirection;
import ExternalDispatcherStrategy.ExternalButtonDispatcher;
import ExternalDispatcherStrategy.FixedFloors;
import Panel.HallPanel;
import Utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private ExternalButtonDispatcher dispatcher;
    private Building building;
    private List<ElevatorController> elevatorControllerList;

    public ElevatorSystem() {
        this.elevatorControllerList = new ArrayList<ElevatorController>();
        for(int i=1; i<=Constant.NO_OF_ELEVATORS; i++) {
            ElevatorController ec = new ElevatorController(i);
            this.elevatorControllerList.add(ec);
            ec.startElevatorController();
        }

        this.dispatcher = new FixedFloors(this.elevatorControllerList);

        this.building = new Building(this.dispatcher);
    }

    // To get the external Hall panel of particular floor
    public HallPanel reqHallPanel(int floor) {
        System.out.println("Return External Hall Panel successfully for floor " + floor );
        return this.building.getHallPanel(floor);
    }

    // Get the elevator when you press the external HallPanel
    public ElevatorController getElevator(HallPanel panel, ExternalButtonDirection direction) {
        System.out.println("Requesting Elevator for the given response");
        return panel.pressButton(direction);
    }

    // this function handles the submitted desired floor where user want to reach
    public void handleReqFromInternalPanel(ElevatorController ec, int requestedFloor) {
        System.out.println("request for the floor " + requestedFloor + " submitted successfully");
        ec.handleInternalReq(requestedFloor);
    }


}
