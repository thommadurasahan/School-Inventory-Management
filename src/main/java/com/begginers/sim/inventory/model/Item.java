package com.begginers.sim.inventory.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short itemId;
    private String voucherNo;
    private short quantity;
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedOn;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;
}
