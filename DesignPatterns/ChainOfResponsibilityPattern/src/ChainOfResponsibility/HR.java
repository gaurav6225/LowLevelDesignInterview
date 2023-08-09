package ChainOfResponsibility;

import Leave.Leave;
import Leave.ReasonType;

public class HR extends LeaveHandler {
    @Override
    public String applyLeave(Leave leave) {
        // The Project Leader has the capability to authorize a leave of up to 14 days at most.
        if(leave.getNoOfDays() <= 21 ) {
            // Employee tier should higher than 4
            if(leave.getEmpTier() <= 3 && !leave.getReasonType().equals(ReasonType.REGULAR)) {
                return "Your leave request has been APPROVED by HR";
            } else {
                return "Your leave request has been DENIED by HR";
            }
        } else {
            return super.applyLeave(leave);
        }
    }
}
