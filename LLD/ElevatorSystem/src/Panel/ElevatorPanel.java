package Panel;

import Buttons.InternalButton;
import Utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class ElevatorPanel {
    private List<InternalButton> buttons = new ArrayList<>();

    public ElevatorPanel() {
        for(int i=1; i<=Constant.NUM_FLOORS; i++) {
            this.buttons.add(new InternalButton(i));
        }
    }

    public void pressButton(int floor) {
        this.buttons.get(floor-1).press();
    }
}
