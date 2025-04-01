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

    @Id
    private int repairId;
    private int sentQuantity;
    private Date sendToRepairOn;
    private String repairLocation;
}