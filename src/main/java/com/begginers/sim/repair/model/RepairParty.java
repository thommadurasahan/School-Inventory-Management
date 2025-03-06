package com.begginers.sim.repair.model;

import java.util.List;

public class RepairParty {
    private int repairPartyId;
    private String repairPartyName;
    private String contactNo;
    private String address;

    // Constructors
    public RepairParty() {}

    public RepairParty(int repairPartyId, String repairPartyName, String contactNo, String address) {
        this.repairPartyId = repairPartyId;
        this.repairPartyName = repairPartyName;
        this.contactNo = contactNo;
        this.address = address;
    }

    // Getters and Setters
    public int getRepairPartyId() { return repairPartyId; }
    public void setRepairPartyId(int repairPartyId) { this.repairPartyId = repairPartyId; }

    public String getRepairPartyName() { return repairPartyName; }
    public void setRepairPartyName(String repairPartyName) { this.repairPartyName = repairPartyName; }

    public String getContactNo() { return contactNo; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public static List<RepairParty> getAllRepairParties() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllRepairParties'");
    }

    public static RepairParty getRepairPartyById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRepairPartyById'");
    }
}
