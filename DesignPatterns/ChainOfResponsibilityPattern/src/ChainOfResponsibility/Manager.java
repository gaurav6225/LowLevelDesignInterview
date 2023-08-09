package ChainOfResponsibility;

import Leave.Leave;
import Leave.ReasonType;

public class Manager extends LeaveHandler {
    @Override
    public String applyLeave(Leave leave) {
        // The Manager has the capability to authorize a leave of more than 21 days.
        if(leave.getNoOfDays() > 21 ) {
            // Employee tier should higher than 2
            if(leave.getEmpTier() <= 2 && leave.getReasonType().equals(ReasonType.SPECIAL)) {
                return "Your leave request has been APPROVED by Manager";
            } else {
                return "Your leave request has been DENIED by Manager";
            }
        } else {
            return super.applyLeave(leave);
        }
    }
}
