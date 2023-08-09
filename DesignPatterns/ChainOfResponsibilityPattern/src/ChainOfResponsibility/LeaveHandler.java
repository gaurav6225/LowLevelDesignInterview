package ChainOfResponsibility;

import Leave.Leave;

public abstract class LeaveHandler {
    private LeaveHandler superVisor;

    //returning "this" will help us to make the chain in a single line in client
    public LeaveHandler setSuperVisor(LeaveHandler superVisor) {
        this.superVisor = superVisor;
        return this;
    }

    public String applyLeave(Leave leave) {
        if(superVisor != null) {
            return superVisor.applyLeave(leave);
        }
        return null;
    }
}
