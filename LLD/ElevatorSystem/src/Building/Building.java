package Building;

import ExternalDispatcherStrategy.ExternalButtonDispatcher;
import Panel.HallPanel;
import Utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<Floor> floors;
    public Building(ExternalButtonDispatcher dispatcher) {
        this.floors = new ArrayList<>();
        for (int i=1; i<=Constant.NUM_FLOORS; i++ ) {
            this.floors.add(new Floor(i,dispatcher));
        }
    }

    public HallPanel getHallPanel(int floorId) {
        return floors.get(floorId-1).getPanelObj();
    }
}
