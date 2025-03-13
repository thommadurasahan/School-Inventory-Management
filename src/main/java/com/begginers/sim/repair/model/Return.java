package com.begginers.sim.repair.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class Return {
    // Todo
    //  Create package exception, include Notfound exception
    //  Create a class ReturnNotFoundException

    @Id
    private int returnId;
    private int repairId;
    private int returnedQuantity;
    private Date returnedOn;
}
