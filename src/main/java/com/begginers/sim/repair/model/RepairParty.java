package com.begginers.sim.repair.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    // Constructors
    public RepairParty() {
    }

    public static List<RepairParty> getAllRepairParties() {

        throw new UnsupportedOperationException("Unimplemented method 'getAllRepairParties'");
    }

    public static RepairParty getRepairPartyById(int id) {

        throw new UnsupportedOperationException("Unimplemented method 'getRepairPartyById'");
    }

    public RepairParty updateRepairParty(int id, RepairParty repairParty) {

        throw new UnsupportedOperationException("Unimplemented method 'updateRepairParty'");
    }

    public void addRepairParty(int id) {

        throw new UnsupportedOperationException("Unimplemented method 'addRepairParty'");
    }
}
