package Buttons;

public class InternalButton {
    public int floorNumber;

    public InternalButton(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    public void press() {
        System.out.println("Internal Button : floor " + this.floorNumber + " has been selected");
    }
}
