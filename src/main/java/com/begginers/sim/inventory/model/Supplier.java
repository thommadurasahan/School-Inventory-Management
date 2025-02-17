package com.begginers.sim.inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Supplier {

    @Id
    private byte supplierId;
    private String supplierName;
    private String supplierAddress;
    private int contactNo;
}
