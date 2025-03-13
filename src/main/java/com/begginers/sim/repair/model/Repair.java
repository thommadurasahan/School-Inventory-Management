package com.begginers.sim.repair.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Repair {
    // Todo
    //  Create package exception, include Notfound exception
    //  Create a class RepairNotFoundException

    // Getters and Setters
    private int repairId;
    private int sentQuantity;
    private Date sendToRepairOn;
    private int repairPartyId;
    private String repairLocation;

    // Constructors
    public Repair() {
    }

}
