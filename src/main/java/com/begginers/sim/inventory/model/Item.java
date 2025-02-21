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
    //private byte typeId;
    private String voucherNo;
    private short quantity;
    private byte supplierId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedOn;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private Type type;
}
