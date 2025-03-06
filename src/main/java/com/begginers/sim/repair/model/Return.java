package com.begginers.sim.repair.model;

import java.util.Date;

public class Return {
    private int returnId;
    private int repairId;
    private int returnedQuantity;
    private Date returnedOn;

    // Constructors
    public Return() {}

    public Return(int returnId, int repairId, int returnedQuantity, Date returnedOn) {
        this.returnId = returnId;
        this.repairId = repairId;
        this.returnedQuantity = returnedQuantity;
        this.returnedOn = returnedOn;
    }

    // Getters and Setters
    public int getReturnId() { return returnId; }
    public void setReturnId(int returnId) { this.returnId = returnId; }

    public int getRepairId() { return repairId; }
    public void setRepairId(int repairId) { this.repairId = repairId; }

    public int getReturnedQuantity() { return returnedQuantity; }
    public void setReturnedQuantity(int returnedQuantity) { this.returnedQuantity = returnedQuantity; }

    public Date getReturnedOn() { return returnedOn; }
    public void setReturnedOn(Date returnedOn) { this.returnedOn = returnedOn; }
}
