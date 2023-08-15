package Client;

import Controller.ElevatorController;
import ElevatorSystem.ElevatorSystem;
import Enums.ExternalButtonDirection;
import Panel.HallPanel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = new ElevatorSystem();
        System.out.println("For requesting external panel given floor id- 1");
        System.out.println("For requesting elevator given hall panel- 2");
        System.out.println("For adding stop for a given elevator- 3");

        Scanner scanner = new Scanner(System.in);
        HallPanel panel = null;
        int floor = 0;
        ExternalButtonDirection direction = ExternalButtonDirection.UP;
        ElevatorController ec = null;
        while (true) {
            int req = scanner.nextInt();
            switch (req) {
                // TestCase-1 : To Get the external panel for a particular floor
                case 1:
                    System.out.print("Type floor number: ");
                    floor = scanner.nextInt();
                    panel = elevatorSystem.reqHallPanel(floor);
                    break;
                // TestCase-2 : To Get the elevator when the user press the button
                case 2:
                    System.out.print("Choose the direction you want to go UP/DOWN --> 0/1: ");
                    int dir = scanner.nextInt();
                    if (dir == 1) direction = ExternalButtonDirection.DOWN;
                    ec = elevatorSystem.getElevator(panel, direction);
                    break;
                // TestCase-3 : handle internal panel requested submitted by the users
                case 3:
                    System.out.print("Type Desired floor number given elevator: ");
                    floor = scanner.nextInt();
                    elevatorSystem.handleReqFromInternalPanel(ec, floor);
                    break;
                default:
                    System.out.println("Invalid input!!!");
            }
        }
    }
}
