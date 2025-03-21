package com.beginners.sim.repair.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class Repair {
    // Todo
    //  Create package exception, include Notfound exception
    //  Create a class RepairNotFoundException

    @Id
    private int repairId;
    private int sentQuantity;
    private Date sendToRepairOn;
    private String repairLocation;
}
