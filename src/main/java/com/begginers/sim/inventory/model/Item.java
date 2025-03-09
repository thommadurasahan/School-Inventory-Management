package com.begginers.sim.inventory.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Item {
    // Todo
    //  Create package exception, include Notfound exception
    //  Create a class ItemNotFoundException

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String itemName;
    private Long typeId;
    private String voucherNo;
    private Long quantity;
    private Long supplierId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedOn;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;
}