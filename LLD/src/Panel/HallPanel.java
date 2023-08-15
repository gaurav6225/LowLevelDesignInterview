package Panel;

import Buttons.ExternalButton;
import Controller.ElevatorController;
import Enums.ExternalButtonDirection;
import ExternalDispatcherStrategy.ExternalButtonDispatcher;

public class HallPanel {
    private ExternalButton upButton;
    private ExternalButton downButton;
    private int floorID;
    private ExternalButtonDispatcher dispatcher;

    public HallPanel(int id, ExternalButtonDispatcher dispatcher) {
        this.floorID = id;
        this.upButton = new ExternalButton(ExternalButtonDirection.UP);
        this.downButton = new ExternalButton(ExternalButtonDirection.DOWN);
        this.dispatcher = dispatcher;
    }

    public ElevatorController pressButton(ExternalButtonDirection direction) {
        if(direction.equals(ExternalButtonDirection.UP)) {
            upButton.press();
        } else {
            downButton.press();
        }
        ElevatorController ec = dispatcher.getElevatorController(this.floorID, direction);
        return ec;
    }

}
