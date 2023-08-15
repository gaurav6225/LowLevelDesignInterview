package Buttons;

import Enums.ExternalButtonDirection;

public class ExternalButton {
    private ExternalButtonDirection direction;
    public ExternalButton(ExternalButtonDirection direction) {
        this.direction = direction;
    }
    public void press() {
        if(this.direction == ExternalButtonDirection.UP) {
            System.out.println("External UP button has been pressed");
        } else {
            System.out.println("External Down button has been pressed");
        }
    }
}
