package Building;

import ExternalDispatcherStrategy.ExternalButtonDispatcher;
import Panel.HallPanel;


public class Floor {
    private int floorId;
    private HallPanel panelObj;

    public Floor(int id, ExternalButtonDispatcher dispatcher) {
        this.floorId = id;
        panelObj = new HallPanel(id, dispatcher);
    }

    public HallPanel getPanelObj() {
        return panelObj;
    }
}
