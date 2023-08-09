package Client;

import Leave.*;
import ChainOfResponsibility.*;

public class LeaveRequestApp {

    public static void main(String[] args) {

        // Create objects of all Concrete Leave Handlers
        LeaveHandler teamLead    = new TeamLeader();
        LeaveHandler projectLead = new ProjectLeader();
        LeaveHandler hr          = new HR();
        LeaveHandler manager     = new Manager();

        // create the chain in a single step
        teamLead.setSuperVisor(projectLead.setSuperVisor(hr.setSuperVisor(manager)));

        // TestCase-1
        Leave leave1 = new Leave(5,4, ReasonType.REGULAR);
        System.out.println(teamLead.applyLeave(leave1));

        // TestCase-2
        Leave leave2 = new Leave(5,5, ReasonType.REGULAR);
        System.out.println(teamLead.applyLeave(leave2));

        // TestCase-3
        Leave leave3 = new Leave(12,3, ReasonType.REGULAR);
        System.out.println(teamLead.applyLeave(leave3));

        // TestCase-4
        Leave leave4 = new Leave(18,2, ReasonType.CRITICAL);
        System.out.println(teamLead.applyLeave(leave4));

        // TestCase-5
        Leave leave5 = new Leave(18,2, ReasonType.REGULAR);
        System.out.println(teamLead.applyLeave(leave5));

        // TestCase-6
        Leave leave6 = new Leave(30,2, ReasonType.SPECIAL);
        System.out.println(teamLead.applyLeave(leave6));

        // TestCase-7
        Leave leave7 = new Leave(30,3, ReasonType.SPECIAL);
        System.out.println(teamLead.applyLeave(leave7));

    }

}
