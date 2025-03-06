package com.begginers.sim.repair.model;

public class ReturnedRepair {
    private int returnedRepairId;
    private int returnId;
    private int repairId;

    // Constructors
    public ReturnedRepair() {}

    public ReturnedRepair(int returnedRepairId, int returnId, int repairId) {
        this.returnedRepairId = returnedRepairId;
        this.returnId = returnId;
        this.repairId = repairId;
    }

    // Getters and Setters
    public int getReturnedRepairId() { return returnedRepairId; }
    public void setReturnedRepairId(int returnedRepairId) { this.returnedRepairId = returnedRepairId; }

    public int getReturnId() { return returnId; }
    public void setReturnId(int returnId) { this.returnId = returnId; }

    public int getRepairId() { return repairId; }
    public void setRepairId(int repairId) { this.repairId = repairId; }
}
