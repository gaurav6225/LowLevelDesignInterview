package ChainOfResponsibility;

import Leave.Leave;

public class TeamLeader extends LeaveHandler {
    @Override
    public String applyLeave(Leave leave) {
        // Suppose the TeamLeader has the authority to grant leaves, with a maximum duration of 7 days.
        if(leave.getNoOfDays() <= 7) {
            // Employee tier should higher than 4
            if(leave.getEmpTier() <= 4) {
                return "Your leave request has been APPROVED by TeamLeader";
            } else {
                return "You employee Tier level is too low for request " + leave.getNoOfDays() + " days";
            }
        } else {
            return super.applyLeave(leave);
        }
    }
}
