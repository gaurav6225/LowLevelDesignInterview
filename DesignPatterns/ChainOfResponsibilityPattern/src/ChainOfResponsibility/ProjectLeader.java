package ChainOfResponsibility;

import Leave.Leave;

public class ProjectLeader extends LeaveHandler{
    @Override
    public String applyLeave(Leave leave) {
        // The Project Leader has the capability to authorize a leave of up to 14 days at most.
        if(leave.getNoOfDays() <= 14 ) {
            // Employee tier should higher than 4
            if(leave.getEmpTier() <= 3) {
                return "Your leave request has been APPROVED by Project Leader";
            } else {
                return "You employee Tier level is too low for request " + leave.getNoOfDays() + " days";
            }
        } else {
            return super.applyLeave(leave);
        }
    }
}
