package Leave;

public class Leave {
    private int noOfDays;
    private int empTier;
    private ReasonType reasonType;

    public Leave(int days, int tier, ReasonType reason) {
        this.noOfDays = days;
        this.empTier = tier;
        this.reasonType = reason;
    }

    // Getters
    public int getNoOfDays() {
        return this.noOfDays;
    }
    public int getEmpTier() {
        return this.empTier;
    }
    public ReasonType getReasonType() {
        return this.reasonType;
    }

    // Setters
    public void setNoOfDays(int days) {
        this.noOfDays = days;
    }
    public void setEmpTier(int tier) {
        this.empTier = tier;
    }
    public void setReasonType(ReasonType reason) {
        this.reasonType = reason;
    }

}
