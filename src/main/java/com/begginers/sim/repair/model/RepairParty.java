package com.begginers.sim.repair.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class RepairParty {
    // Todo
    //  Create package exception, include Notfound exception
    //  Create a class RepairPartyNotFoundException

    @Id
    private int repairPartyId;
    private String repairPartyName;
    private String contactNo;
    private String address;
}
