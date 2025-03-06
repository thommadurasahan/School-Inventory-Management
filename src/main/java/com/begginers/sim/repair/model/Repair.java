package com.begginers.sim.repair.model;

import java.util.Date;

public class Repair {
    private int repairId;
    private int sentQuantity;
    private Date sendToRepairOn;
    private int repairPartyId;
    private String repairLocation;

    // Constructors
    public Repair() {}

    public Repair(int repairId, int sentQuantity, Date sendToRepairOn, int repairPartyId, String repairLocation) {
        this.repairId = repairId;
        this.sentQuantity = sentQuantity;
        this.sendToRepairOn = sendToRepairOn;
        this.repairPartyId = repairPartyId;
        this.repairLocation = repairLocation;
    }

    // Getters and Setters
    public int getRepairId() { return repairId; }
    public void setRepairId(int repairId) { this.repairId = repairId; }

    public int getSentQuantity() { return sentQuantity; }
    public void setSentQuantity(int sentQuantity) { this.sentQuantity = sentQuantity; }

    public Date getSendToRepairOn() { return sendToRepairOn; }
    public void setSendToRepairOn(Date sendToRepairOn) { this.sendToRepairOn = sendToRepairOn; }

    public int getRepairPartyId() { return repairPartyId; }
    public void setRepairPartyId(int repairPartyId) { this.repairPartyId = repairPartyId; }

    public String getRepairLocation() { return repairLocation; }
    public void setRepairLocation(String repairLocation) { this.repairLocation = repairLocation; }
}
