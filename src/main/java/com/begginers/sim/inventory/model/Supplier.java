package com.begginers.sim.inventory.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte supplierId;
    private String supplierName;
    private String supplierAddress;
    private int supplierContactNo;
    @Temporal(TemporalType.DATE)
    private Date supplierAddedOn;

    @OneToMany(mappedBy = "supplier")
    private List<Item> items;
}
